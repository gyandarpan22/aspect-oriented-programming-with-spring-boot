package com.gyan.darpan.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
@Log4j2
//@Order(2)
public class LoggingAspect {

//    @Pointcut("@annotation(com.gyan.darpan.aspect.annotation.LogExecution)  || execution(* com.gyan..*Controller.*(..))")
//    public void logExecutionPoint() {
//    }

    @Pointcut("@annotation(com.gyan.darpan.aspect.annotation.LogExecution)")
    public void logExecutionPoint() {
    }

    @Pointcut("execution(* com.gyan..*Controller.*(..))")
    public void controllerClassPointCut() {
    }

    @Around("logExecutionPoint() || controllerClassPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        String methodName = methodSignature.getName();
        String className = methodSignature.getDeclaringTypeName();

        log.info("Before method execution , methodName :{} ,className : {}", methodName, className);

        Object result;
        try {
            result = proceedingJoinPoint.proceed();

            log.info("After method execution completed successfully methodName :{} ,className : {}", methodName, className);
        } catch (IOException ioException) {
            log.error("IOException occur : ", ioException);
            throw ioException;
        } catch (Throwable throwable) {
            log.error("Throwable occur :", throwable);
            throw throwable;
        } finally {
            log.info("Inside finally methodName :{} ,className : {}", methodName, className);
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
