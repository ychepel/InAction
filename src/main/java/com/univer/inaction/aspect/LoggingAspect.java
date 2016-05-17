package com.univer.inaction.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
@Aspect
public class LoggingAspect {

    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.univer.inaction.entity.*.*(..))")
    public void printEntityMethodsLog(JoinPoint joinPoint) {
        System.out.println("Method: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.univer.inaction.controller.*.*(..)) && args (..,result)")
    public void printBindingResultError(BindingResult result) {
        logger.debug("result.hasErrors()=" + result.hasErrors() + "; result=" + result);
    }
}
