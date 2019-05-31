package ua.gladiator.taxi.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "ua.gladiator.taxi.model.entity")
@EnableJpaRepositories(basePackages = {"ua.gladiator.taxi.model.repository"})
public class TaxiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaxiApplication.class, args);
    }

}