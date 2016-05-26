package com.univer.inaction.validator;

import com.univer.inaction.entity.User;
import com.univer.inaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserUniqueValidator {

    @Autowired
    private UserService userService;

    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if(userService.getByName(user.getName()) != null) {
            errors.rejectValue("name", "name.not.unique");
        }
        if(userService.getByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "email.not.unique");
        }
    }
}
