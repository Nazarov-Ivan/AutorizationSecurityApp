package ru.alishev.springcourse.FirstSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.alishev.springcourse.FirstSecurityApp.models.Person;
import ru.alishev.springcourse.FirstSecurityApp.models.PersonRoles;
import ru.alishev.springcourse.FirstSecurityApp.models.Roles;
import ru.alishev.springcourse.FirstSecurityApp.repositories.PeopleRepository;
import ru.alishev.springcourse.FirstSecurityApp.repositories.PersonRolesRepository;
import ru.alishev.springcourse.FirstSecurityApp.repositories.RolesRepository;
import ru.alishev.springcourse.FirstSecurityApp.security.PersonDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Neil Alishev
 */
@Service
public class PersonDetailsService implements UserDetailsService {

    private final PeopleRepository peopleRepository;
    private final PersonRolesRepository personRolesRepository;
    private final RolesRepository rolesRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository, PersonRolesRepository personRolesRepository, RolesRepository rolesRepository) {
        this.peopleRepository = peopleRepository;
        this.personRolesRepository = personRolesRepository;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByUsername(s);
        if (person.isEmpty())
            throw new UsernameNotFoundException("User not found");

        List<PersonRoles> personRoles = personRolesRepository.findAllByPerson(person.get());
        List<Roles> roles = new ArrayList<>();
        for (int i = 0; i < personRoles.size(); i++) {
            roles.add(rolesRepository.findById(personRoles.get(i).getRole().getId()).get());
        }

        return new PersonDetails(person.get(), personRoles, roles);
    }

}
