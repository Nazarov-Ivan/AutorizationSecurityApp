package ru.alishev.springcourse.FirstSecurityApp.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 25)
    @NotNull
    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<PersonRoles> personRoles = new LinkedHashSet<>();

    public Set<PersonRoles> getPersonRoles() {
        return personRoles;
    }

    public void setPersonRoles(Set<PersonRoles> personRoles) {
        this.personRoles = personRoles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    TODO [JPA Buddy] create field to map the 'authorities' column
//     Available actions: Define target Java type | Uncomment as is | Remove column mapping
//    @Column(name = "authorities", columnDefinition = "varchar[]")
    @Column(name = "authorities")
    private String authority;


    public List<String> getAuthorities() {
        String delimeter = ", "; // Разделитель
        String[] subStr = authority.split(delimeter);
        return List.of(subStr);
    }

//    @Transient
//    List<String> authorities = List.of(authority.split(", "));

//    public void setAuthorities(Object authorities) {
//        this.authorities = authorities;
//    }

//@Id
//@Column(name = "id")
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//private int id;
//
//    @NotEmpty(message = "Название роли не должно быть пустым")
//    @Size(min = 2, max = 25, message = "Имя должно быть от 2 до 100 символов длиной")
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "authorities")
//    private List<String> authorities;
//
//    public Roles() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAuthorities() {
//        return authorities;
//    }
//
//    public void setAuthorities(String authorities) {
//        this.authorities = authorities;
//    }
}
