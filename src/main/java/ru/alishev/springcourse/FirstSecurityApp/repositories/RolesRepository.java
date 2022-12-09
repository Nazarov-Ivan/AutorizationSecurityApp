package ru.alishev.springcourse.FirstSecurityApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alishev.springcourse.FirstSecurityApp.models.Person;
import ru.alishev.springcourse.FirstSecurityApp.models.PersonRoles;
import ru.alishev.springcourse.FirstSecurityApp.models.Roles;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
//    Optional<Roles> findById();
//    List<Roles> findAllByPerson(Person person);
}
