package com.example.inicial1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@SpringBootApplication
public class PersonaApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonaApplication.class, args);
    }
}