package com.example.spring251;

import com.example.spring251.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class Spring251Application implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Spring251Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {
        System.out.println(userService.getUser(1));
        System.out.println(userService.getUser(2));
    }

}
