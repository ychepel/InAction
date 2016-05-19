package com.univer.inaction.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    private static Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

    @Around(value="execution(* com.univer.inaction..*.*(..))")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - startTime;
        logger.debug("Method `"+ pjp.getSignature() +"` took " + elapsedTime + " milliseconds to execute.");
        return output;
    }
}
