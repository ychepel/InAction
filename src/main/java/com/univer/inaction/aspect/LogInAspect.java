package com.univer.inaction.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogInAspect {

    @Before("execution(* com.univer.inaction.home.*.*(..))")
    public void homeMethodsLog(JoinPoint joinPoint) {
        System.out.println("Method: " + joinPoint.getSignature().getName());
    }
}
