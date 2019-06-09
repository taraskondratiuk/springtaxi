package ua.gladiator.taxi.model.entity;

import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.gladiator.taxi.model.entity.enums.Role;
import ua.gladiator.taxi.model.entity.enums.SocialStatus;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@Table(name = "clients")
public class Client implements UserDetails {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;


    @NotEmpty
    @Basic(optional = false)
    @Column(name = "login",unique=true, nullable = false)
    private String login;

    @NotEmpty
    private String password;

    @Enumerated(EnumType.STRING)
    private SocialStatus socialStatus;

    private Long totalSpentValue;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Integer personalDiscount;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(getRole());
    }



    @Override
    public String getUsername() {
        return getLogin();
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
}
