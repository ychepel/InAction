package com.univer.inaction.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    @Around(value="execution(* com.univer.inaction..*.*(..))")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Method `"+ pjp.getSignature() +"` took " + elapsedTime + " milliseconds to execute.");
        return output;
    }
}
