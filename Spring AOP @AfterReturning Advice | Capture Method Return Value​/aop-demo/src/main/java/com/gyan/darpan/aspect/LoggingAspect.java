package com.gyan.darpan.aspect;

import com.gyan.darpan.aspect.annotation.LogExecution;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Log4j2
public class LoggingAspect {

    @AfterReturning(
            pointcut = "@annotation(com.gyan.darpan.aspect.annotation.LogExecution)",
            returning = "result")
    public void afterReturnAdvice(JoinPoint joinPoint, Object result) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        log.info("LoggingAspect.afterReturnAdvice():: className : {}", methodSignature.getDeclaringTypeName());

        log.info("LoggingAspect.afterReturnAdvice():: methodName : {}", methodSignature.getName());

        Method method = methodSignature.getMethod();

        LogExecution logExecution = method.getAnnotation(LogExecution.class);

        log.info("LoggingAspect.afterReturnAdvice():: annotation value : {}", logExecution.value());

        log.info("LoggingAspect.afterReturnAdvice():: Result : {}", result);
    }
}
