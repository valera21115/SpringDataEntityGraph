package com.example.spring251.service;

import com.example.spring251.domain.User;
import com.example.spring251.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUser(int id){
        return userRepository.getById(id).orElseThrow();
    }
}
