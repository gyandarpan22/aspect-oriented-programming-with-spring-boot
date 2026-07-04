package com.gyan.darpan.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
@Log4j2
@Order(2)
public class LoggingAspect {

    @Pointcut("@annotation(com.gyan.darpan.aspect.annotation.LogExecution)")
    public void logExecutionPoint() {
    }

    @Around("logExecutionPoint()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("Before method execution");

        Object result;
        try {
            result = proceedingJoinPoint.proceed();

            log.info("After method execution completed successfully");
        } catch (IOException ioException) {
            log.error("IOException occur : ", ioException);
            throw ioException;
        } catch (Throwable throwable) {
            log.error("Throwable occur :", throwable);
            throw throwable;
        } finally {
            log.info("Inside finally");
        }

        return result;
    }


//    @Before("logExecutionPoint()")
//    public void before(JoinPoint joinPoint) {
//        log.info("Before method executed");
//    }
//
//    @AfterReturning(pointcut = "logExecutionPoint()",
//            returning = "result")
//    public void afterReturning(JoinPoint joinPoint, Object result) {
//        log.info("afterReturning method executed :: result : {}", result);
//    }
//
//    @AfterThrowing(pointcut = "logExecutionPoint()", throwing = "exception")
//    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
//        log.error("afterThrowing method executed : ", exception);
//    }
//
//    @After("logExecutionPoint()")
//    public void after() {
//        log.info("After method executed");
//    }
}
