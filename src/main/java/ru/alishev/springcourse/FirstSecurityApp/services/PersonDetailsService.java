package ru.alishev.springcourse.FirstSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.alishev.springcourse.FirstSecurityApp.models.Authorities;
import ru.alishev.springcourse.FirstSecurityApp.models.Person;
import ru.alishev.springcourse.FirstSecurityApp.models.PersonRoles;
import ru.alishev.springcourse.FirstSecurityApp.models.Roles;
import ru.alishev.springcourse.FirstSecurityApp.repositories.AuthoritiesRepository;
import ru.alishev.springcourse.FirstSecurityApp.repositories.PeopleRepository;
import ru.alishev.springcourse.FirstSecurityApp.repositories.PersonRolesRepository;
import ru.alishev.springcourse.FirstSecurityApp.repositories.RolesRepository;
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

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository, PersonRolesRepository personRolesRepository, RolesRepository rolesRepository, AuthoritiesRepository authoritiesRepository) {
        this.peopleRepository = peopleRepository;
        this.personRolesRepository = personRolesRepository;
        this.rolesRepository = rolesRepository;
        this.authoritiesRepository = authoritiesRepository;
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
            List<String> accesses = new ArrayList<>();
            for (int j = 0; j < authorities1.size(); j++) {
                accesses.add(authorities1.get(j).getAccess());
            }
            authorities.add(accesses);
        }

        return new PersonDetails(person.get(), personRoles, roles, authorities);
    }

}
