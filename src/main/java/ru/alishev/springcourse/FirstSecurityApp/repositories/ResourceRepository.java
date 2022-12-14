package ru.alishev.springcourse.FirstSecurityApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alishev.springcourse.FirstSecurityApp.models.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {
}