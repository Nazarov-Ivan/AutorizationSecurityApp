package ru.alishev.springcourse.FirstSecurityApp.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.alishev.springcourse.FirstSecurityApp.models.Authorities;
import ru.alishev.springcourse.FirstSecurityApp.models.Person;
import ru.alishev.springcourse.FirstSecurityApp.models.PersonRoles;
import ru.alishev.springcourse.FirstSecurityApp.models.Roles;
import ru.alishev.springcourse.FirstSecurityApp.repositories.AuthoritiesRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Nazarov Ivan
 */
public class PersonDetails implements UserDetails {
    private final Person person;
    private final List<PersonRoles> personRoles;
    private final List<Roles> roles;
    private final List<List<String>> authorities;

    public PersonDetails(Person person, List<PersonRoles> personRoles, List<Roles> roles, List<List<String>> authorities) {
        this.person = person;
        this.personRoles = personRoles;
        this.roles = roles;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // SHOW_ACCOUNT, WITHDRAW_MONEY, SEND_MONEY
        // ROLE_ADMIN, ROLE_USER - это роли
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        List<String> access = new ArrayList<>();
        for (int i = 0; i < personRoles.size(); i++) {
//            List<String> authorities = roles.get(i).getAuthoritiesList();
            int roleId = roles.get(i).getId();

//            access.add(authorities.get(i).get(roleId).getAccess());
            for (int j = 0; j < authorities.size(); j++) {
                if (timestamp.after(personRoles.get(i).getFromDate()) && timestamp.before(personRoles.get(i).getByDate())) {
                    for (int k = 0; k < authorities.get(j).size(); k++) {
                        list.add(new SimpleGrantedAuthority(authorities.get(j).get(k)));
                    }
                }
            }
        }
//        return Collections.singletonList(new SimpleGrantedAuthority(person.getRole()));
        return list;
    }

    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Нужно, чтобы получать данные аутентифицированного пользователя
    public Person getPerson() {
        return this.person;
    }
}
