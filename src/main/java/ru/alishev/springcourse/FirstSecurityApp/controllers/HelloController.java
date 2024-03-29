package ru.alishev.springcourse.FirstSecurityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.alishev.springcourse.FirstSecurityApp.models.AccessLevel;
import ru.alishev.springcourse.FirstSecurityApp.security.PersonDetails;
import ru.alishev.springcourse.FirstSecurityApp.services.AdminService;

/**
 * @author Nazarov Ivan
 */
@Controller
public class HelloController {
    private final AdminService adminService;

    @Autowired
    public HelloController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());

        return "hello";
    }

    String edit = "edit";
    @GetMapping("/admin")
    public String adminPage() {
        adminService.doAdminStuff(edit);
        return "admin";
    }
}
