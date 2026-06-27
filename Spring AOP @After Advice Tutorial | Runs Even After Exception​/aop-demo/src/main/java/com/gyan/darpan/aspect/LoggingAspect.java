package com.gyan.darpan.aspect;

import com.gyan.darpan.aspect.annotation.LogExecution;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Log4j2
public class LoggingAspect {

    @After("@annotation(com.gyan.darpan.aspect.annotation.LogExecution)")
    public void afterAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        log.info("LoggingAspect.afterAdvice():: className : {}", methodSignature.getDeclaringTypeName());

        log.info("LoggingAspect.afterAdvice():: methodName : {}", methodSignature.getName());

        Method method = methodSignature.getMethod();

        LogExecution logExecution = method.getAnnotation(LogExecution.class);

        log.info("LoggingAspect.afterAdvice():: annotation value : {}", logExecution.value());
    }
}
