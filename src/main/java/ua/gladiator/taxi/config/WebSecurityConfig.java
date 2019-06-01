package ua.gladiator.taxi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;
import ua.gladiator.taxi.model.entity.Client;
import ua.gladiator.taxi.model.service.impl.ClientService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final ClientService clientService;

    @Autowired
    public WebSecurityConfig(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
/*        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        UserDetails user1 =
                User.withDefaultPasswordEncoder()
                        .username("user1")
                        .password("password1")
                        .roles("USER")
                        .build();*/
        List<UserDetails> list = new ArrayList<>();
        List<Client> clients = clientService.getAll();

        clients.forEach(v->
                list.add(User

                        .withDefaultPasswordEncoder()
                        .username(v.getLogin())
                        .password(v.getPassword())
                        .roles(v.getUserType())
                        .build())
        );


        return new InMemoryUserDetailsManager(list);
    }
}