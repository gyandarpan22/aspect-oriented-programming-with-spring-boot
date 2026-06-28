package com.gyan.darpan.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class LoggingAspect {

    @Pointcut("@annotation(com.gyan.darpan.aspect.annotation.LogExecution)")
    public void logExecutionPoint() {
    }

    @Before("logExecutionPoint()")
    public void before(JoinPoint joinPoint) {
        log.info("Before method executed");
    }

    @AfterReturning(pointcut = "logExecutionPoint()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        log.info("afterReturning method executed :: result : {}", result);
    }

    @AfterThrowing(pointcut = "logExecutionPoint()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        log.error("afterThrowing method executed : ", exception);
    }

    @After("logExecutionPoint()")
    public void after() {
        log.info("After method executed");
    }
}
