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
        user.setPassword(passwordEncoder.encode(user.getInputPassword()));
        return userRepository.save(user);
    }

    public User getById(int id) {
        return userRepository.findOne(id);
    }

    public User getByName(String name) { return userRepository.findByName(name);}

    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean contains(String inputName, String inputPassword) {
        User user = getByName(inputName);
        if(user != null) {
            if(passwordEncoder.matches(inputPassword, user.getPassword())) {
                return true;
            }
        }
        return false;
    }


}
