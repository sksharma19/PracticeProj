package com.hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;

@SpringBootApplication
public class RunBookApp {

    public static void main(String[] args) {
        SpringApplication.run(RunBookApp.class, args);
    }

    @Profile("demo")
    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            repository.save(new Book("Book Description1", "Book1", new BigDecimal("76.32")));
            repository.save(new Book("Bood Description 2", "Book2", new BigDecimal("23.1")));
            repository.save(new Book("Book Description 3", "Book3", new BigDecimal("54.65")));
        };
    }
}