package ru.alishev.springcourse.FirstSecurityApp.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


/**
 * @author Nazarov Ivan
 * @date 12/11/2022
 */

@Entity
@Table(name = "authorities")
public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Roles role;

    @Column(name = "access")
    private String access;



//    @OneToMany(mappedBy = "authority")
//    private Set<Roles> roles = new LinkedHashSet<>();

//    public Set<Roles> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Roles> roles) {
//        this.roles = roles;
//    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

//    @Column(name = "admin")
//    private String admin;
//
//    @Column(name = "hello")
//    private String hello;
//
////    @OneToMany(mappedBy = "authorities")
////    private Set<Roles> roles = new LinkedHashSet<>();
//
////    public Set<Roles> getRoles() {
////        return roles;
////    }
////
////    public void setRoles(Set<Roles> roles) {
////        this.roles = roles;
////    }
//
//    public String getHello() {
//        return hello;
//    }
//
//    public void setHello(String hello) {
//        this.hello = hello;
//    }
//
//    public String getAdmin() {
//        return admin;
//    }
//
//    public void setAdmin(String admin) {
//        this.admin = admin;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
}
