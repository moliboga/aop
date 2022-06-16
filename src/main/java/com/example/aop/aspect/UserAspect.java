package com.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalTime;

@Aspect
@Component
public class UserAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.example.aop..*(..)))")
    public void allMethods() {}

    @Around("allMethods()")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        Object result = joinPoint.proceed();

        logger.info("Method \"{}\" of \"{}\" executing ended at {}",
                joinPoint.getSignature().getName(),
                joinPoint.getSignature().getDeclaringType().getSimpleName(),
                java.time.LocalTime.now());

        return result;
    }
}
