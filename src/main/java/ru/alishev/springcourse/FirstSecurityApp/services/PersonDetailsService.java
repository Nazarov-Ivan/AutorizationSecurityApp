package ru.alishev.springcourse.FirstSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.alishev.springcourse.FirstSecurityApp.models.*;
import ru.alishev.springcourse.FirstSecurityApp.repositories.*;
import ru.alishev.springcourse.FirstSecurityApp.security.PersonDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Nazarov Ivan
 */
@Service
public class PersonDetailsService implements UserDetailsService {

    private final PeopleRepository peopleRepository;
    private final PersonRolesRepository personRolesRepository;
    private final RolesRepository rolesRepository;
    private final AuthoritiesRepository authoritiesRepository;
    private final ResourceRepository resourceRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository, PersonRolesRepository personRolesRepository, RolesRepository rolesRepository, AuthoritiesRepository authoritiesRepository, ResourceRepository resourceRepository) {
        this.peopleRepository = peopleRepository;
        this.personRolesRepository = personRolesRepository;
        this.rolesRepository = rolesRepository;
        this.authoritiesRepository = authoritiesRepository;
        this.resourceRepository = resourceRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByUsername(s);
        if (person.isEmpty())
            throw new UsernameNotFoundException("User not found");

        List<PersonRoles> personRoles = personRolesRepository.findAllByPerson(person.get());
        List<Roles> roles = new ArrayList<>();
        List<List<String>> authorities= new ArrayList<>();

        for (int i = 0; i < personRoles.size(); i++) {
            roles.add(rolesRepository.findById(personRoles.get(i).getRole().getId()).get());
        }
        for (int i = 0; i < roles.size(); i++) {
            List<Authorities> authorities1 = authoritiesRepository.findAllByRole(roles.get(i));
//            for (int l=0; l < resourceList.size(); l ++) {

                Authorities authorities2 = authoritiesRepository.findByRoleAndResource(roles.get(i), resourceRepository.findById(1).get());
//            }
            List<String> accesses = new ArrayList<>();
            for (int j = 0; j < authorities1.size(); j++) {
                accesses.add(authorities1.get(j).getAccess()+"_"+authorities1.get(j).getResource().getName());
            }
            authorities.add(accesses);
        }

        return new PersonDetails(person.get(), personRoles, roles, authorities);
    }

}
