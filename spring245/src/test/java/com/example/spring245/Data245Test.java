package com.example.spring245;

import com.example.spring245.domain.User;
import com.example.spring245.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Data245Test {
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
//        assertThrows(org.hibernate.LazyInitializationException.class, () -> System.out.println( userRepository.getById(1)));
    }

}
