package com.example.securityjwtrestapijson.service;

import com.example.securityjwtrestapijson.entity.UserEntity;
import com.example.securityjwtrestapijson.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
