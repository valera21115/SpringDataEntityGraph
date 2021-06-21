package com.example.spring251;

import com.example.spring251.domain.User;
import com.example.spring251.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Data251Test {
    @Autowired
    UserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Test
    void user() {
        User user = userRepository.getById(1).orElseThrow();
        assertEquals("HR", user.getDepartment().getName());
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Test
    void exception() {
        User user = userRepository.getById(1).orElseThrow();
        assertEquals("HR", user.getDepartment().getName());
//        assertThrows(org.hibernate.LazyInitializationException.class, () -> System.out.println(user.getDepartment()));
    }

}
