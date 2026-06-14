package com.gyan.darpan.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.gyan.darpan.service.*.*(..))")
    public void beforePointCut(JoinPoint joinPoint) {
        log.info("LoggingAspect.beforePointCut()");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        log.info("LoggingAspect.beforePointCut() : Method Name :{} ", methodSignature.getName());

        log.info("LoggingAspect.beforePointCut() : Class Name :{} ", methodSignature.getDeclaringTypeName());

    }
}
