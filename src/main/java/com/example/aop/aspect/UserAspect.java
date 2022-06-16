package com.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
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

    @Pointcut("execution(public * *(..))")
    public void publicMethod() {}

    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void withinService() {}

//    @Around("publicMethod() && withinService()")
    @Around("execution(* com.example..*(..)))")
//    @Around("execution(* com.example.aop..*(..)))")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        LocalTime start = java.time.LocalTime.now();
        logger.info("Method \"{}\" of \"{}\" executing started at {}",
                joinPoint.getSignature().getName(),
                joinPoint.getSignature().getDeclaringType().getSimpleName(),
                start);

        Object result = joinPoint.proceed();

        LocalTime end = java.time.LocalTime.now();
        logger.info("Method \"{}\" of \"{}\" executing ended at {}. Total time is {}",
                joinPoint.getSignature().getName(),
                joinPoint.getSignature().getDeclaringType().getSimpleName(),
                end,
                Duration.between(start, end).getNano());
        return result;
    }
}
