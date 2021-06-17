package com.example.spring245;

import com.example.spring245.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Spring245Application implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Spring245Application.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {
        System.out.println(userService.getUser(1));
        System.out.println(userService.getUser(2));
    }

}
