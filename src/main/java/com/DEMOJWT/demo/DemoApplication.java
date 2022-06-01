package com.DEMOJWT.demo;

import com.DEMOJWT.demo.Entity.User;
import com.DEMOJWT.demo.repository.UserRepository;
import com.DEMOJWT.demo.security.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void userInit() {
        List<User> listUser = Stream.of(
                new User(1L, "juanes", "12345"),
                new User(2L, "juantoro", "56789")


        ).collect(Collectors.toList());
        userRepository.saveAll(listUser);
    }

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/login").permitAll()
                    .anyRequest().authenticated();
        }
    }


}
