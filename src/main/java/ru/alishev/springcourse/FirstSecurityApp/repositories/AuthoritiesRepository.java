package ru.alishev.springcourse.FirstSecurityApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alishev.springcourse.FirstSecurityApp.models.Authorities;

/**
 * @author Nazarov Ivan
 * @date 12/11/2022
 */
public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer> {
}
