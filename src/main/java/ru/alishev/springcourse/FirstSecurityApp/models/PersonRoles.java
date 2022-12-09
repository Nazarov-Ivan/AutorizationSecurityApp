package ru.alishev.springcourse.FirstSecurityApp.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "person_roles")
public class PersonRoles {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles role;

    @Column(name = "from_date")
    private Timestamp fromDate;

    @Column(name = "by_date")
    private Timestamp byDate;

    public PersonRoles() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public Timestamp getByDate() {
        return byDate;
    }

    public void setByDate(Timestamp byDate) {
        this.byDate = byDate;
    }
}
