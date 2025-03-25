package ru.otus.microservices_novikova;

import org.springframework.boot.SpringApplication;

public class TestApp {

    public static void main(String[] args) {
        SpringApplication.from(Application::main)
                .with(ContainersConfiguration.class)
                .run(args);
    }

}