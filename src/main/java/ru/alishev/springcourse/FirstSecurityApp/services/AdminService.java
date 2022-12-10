package ru.alishev.springcourse.FirstSecurityApp.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ru.alishev.springcourse.FirstSecurityApp.models.AccessLevel;

/**
 * @author Nazarov Ivan
 */
@Service
public class AdminService {

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PreAuthorize("hasAuthority('edit_admin') or hasAuthority('read_admin')")
    public void doAdminStuff(String string) {
        System.out.println("Only admin here");
    }
}
