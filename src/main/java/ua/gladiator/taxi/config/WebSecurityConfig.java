package ua.gladiator.taxi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ua.gladiator.taxi.model.entity.Client;
import ua.gladiator.taxi.model.service.ClientService;
import ua.gladiator.taxi.model.service.impl.ClientServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final ClientServiceImpl clientServiceImpl;

    private final LoginSuccessHandler loginSuccessHandler;

    @Autowired
    public WebSecurityConfig(ClientServiceImpl clientServiceImpl, LoginSuccessHandler loginSuccessHandler) {
        this.clientServiceImpl = clientServiceImpl;
        this.loginSuccessHandler = loginSuccessHandler;
    }

@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index", "/register", "/register/**", "/js/**", "/css/**", "/sources/**").permitAll()
                .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/user/**").hasAnyAuthority( "ROLE_USER")

                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").successHandler(loginSuccessHandler).permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();
    }

/*    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }*/
 @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(clientServiceImpl)
        .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

}
