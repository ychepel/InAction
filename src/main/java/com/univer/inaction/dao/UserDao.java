package com.univer.inaction.dao;

import com.univer.inaction.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
