package ru.alishev.springcourse.FirstSecurityApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alishev.springcourse.FirstSecurityApp.models.Authorities;
import ru.alishev.springcourse.FirstSecurityApp.models.Roles;

import java.util.List;
import java.util.Optional;

/**
 * @author Nazarov Ivan
 * @date 12/11/2022
 */
public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer> {
    List<Authorities> findAllByRole(Roles role);
}
