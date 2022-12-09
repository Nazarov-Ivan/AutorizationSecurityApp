package ru.alishev.springcourse.FirstSecurityApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alishev.springcourse.FirstSecurityApp.models.Person;
import ru.alishev.springcourse.FirstSecurityApp.models.PersonRoles;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRolesRepository extends JpaRepository<PersonRoles, Integer> {
    List<PersonRoles> findAllByPerson(Person person);
}
