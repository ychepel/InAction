package com.univer.inaction.validator;

import com.univer.inaction.entity.User;
import com.univer.inaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserUniqueValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
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
