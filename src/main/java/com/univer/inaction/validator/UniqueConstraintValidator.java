package com.univer.inaction.validator;

import com.univer.inaction.entity.User;
import com.univer.inaction.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class UniqueConstraintValidator implements ConstraintValidator<Unique, String> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(Unique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if(userService.getByName(name) != null) {
            log.debug("*************************************Name `" + name + "`is not unique");
            return false;
        }
//        if(userService.getByEmail(user.getEmail()) != null) {
//            log.debug("*************************************Email is not unique");
//            return false;
//        }
        log.debug("*************************************Name `" + name + "` is unique");
        return true;
    }
}
