package com.gyan.darpan.aspect;

import com.gyan.darpan.aspect.annotation.LogExecution;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Log4j2
public class LoggingAspect {

    @Before("@annotation(com.gyan.darpan.aspect.annotation.LogExecution)")
    public void beforeAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        log.info("LoggingAspect.beforeAdvice():: className : {}", methodSignature.getDeclaringTypeName());

        log.info("LoggingAspect.beforeAdvice():: methodName : {}", methodSignature.getName());

        Method method = methodSignature.getMethod();

        LogExecution logExecution = method.getAnnotation(LogExecution.class);

        log.info("LoggingAspect.beforeAdvice():: annotation value : {}", logExecution.value());
    }
}
