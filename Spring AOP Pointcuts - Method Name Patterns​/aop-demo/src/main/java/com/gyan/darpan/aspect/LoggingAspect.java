package com.gyan.darpan.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class LoggingAspect {

    @Before("execution(* com.gyan.darpan..*.*(..))")
    //@Before("execution(* com.gyan.darpan..*.*User(..))")
    //@Before("execution(* com.gyan.darpan..*.addUser(..))")
    public void beforeExecutionDemo(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        log.info("LoggingAspect.beforeExecutionDemo():: className : {}", methodSignature.getDeclaringTypeName());
        log.info("LoggingAspect.beforeExecutionDemo():: methodName : {}", methodSignature.getName());
    }
}
