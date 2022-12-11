package ru.alishev.springcourse.FirstSecurityApp.models;

import javax.persistence.*;
import java.util.LinkedHashSet;
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

    @Column(name = "admin")
    private String admin;

    @Column(name = "hello")
    private String hello;

//    @OneToMany(mappedBy = "authorities")
//    private Set<Roles> roles = new LinkedHashSet<>();

//    public Set<Roles> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Roles> roles) {
//        this.roles = roles;
//    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
