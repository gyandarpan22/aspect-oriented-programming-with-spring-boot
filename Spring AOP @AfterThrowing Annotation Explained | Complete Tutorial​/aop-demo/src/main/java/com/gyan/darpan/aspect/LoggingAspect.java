package com.gyan.darpan.aspect;

import com.gyan.darpan.aspect.annotation.LogExecution;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Method;

@Aspect
@Component
@Log4j2
public class LoggingAspect {

    @AfterThrowing(
            pointcut = "@annotation(com.gyan.darpan.aspect.annotation.LogExecution)",
            throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, IOException ex) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        log.info("LoggingAspect.afterThrowing():: className : {}", methodSignature.getDeclaringTypeName());

        log.info("LoggingAspect.afterThrowing():: methodName : {}", methodSignature.getName());

        Method method = methodSignature.getMethod();

        LogExecution logExecution = method.getAnnotation(LogExecution.class);

        log.info("LoggingAspect.afterThrowing():: annotation value : {}", logExecution.value());

        log.info("LoggingAspect.afterThrowing():: Exception : ", ex);
    }
}
