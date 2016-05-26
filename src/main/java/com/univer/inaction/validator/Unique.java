package com.univer.inaction.validator;

import com.univer.inaction.entity.User;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueConstraintValidator.class)
@Target( {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {

    String message() default "{org.hibernate.validator.constraints.Unique.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
