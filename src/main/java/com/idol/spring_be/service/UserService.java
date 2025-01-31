package com.idol.spring_be.service;
import com.idol.spring_be.entity.User;

import org.springframework.stereotype.Service;

import com.idol.spring_be.dto.UserInfo;
import com.idol.spring_be.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    public User createUser(UserInfo userInfo) {
        User user = User.builder()
                        .username(userInfo.getUsername())
                        .password(userInfo.getPassword())
                        .email(userInfo.getEmail())
                        .build();

        return userRepository.save(user);
    }

    public User getUserById(UserInfo userInfo) {
        return userRepository.findByUsername(userInfo.getUsername());
    }

    public void deleteUser(UserInfo userInfo) {
        userRepository.deleteByUsername(userInfo.getUsername());
    }
}