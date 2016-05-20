package com.univer.inaction.service;

import com.univer.inaction.repository.UserRepository;
import com.univer.inaction.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getOriginalPassword()));
        return userRepository.save(user);
    }

    public User getById(int id) {
        return userRepository.findOne(id);
    }
}
