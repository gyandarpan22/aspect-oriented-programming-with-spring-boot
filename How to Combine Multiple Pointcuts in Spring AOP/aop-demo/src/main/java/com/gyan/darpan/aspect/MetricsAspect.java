//package com.gyan.darpan.aspect;
//
//import com.gyan.darpan.aspect.annotation.Metrics;
//import lombok.extern.log4j.Log4j2;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.slf4j.MDC;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.lang.reflect.Method;
//
//@Aspect
//@Component
//@Log4j2
//@Order(1)
//public class MetricsAspect {
//
//    @Pointcut("@annotation(com.gyan.darpan.aspect.annotation.Metrics)")
//    public void metricsPointCut() {
//    }
//
//    @Around("metricsPointCut()")
//    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        long startTime = System.currentTimeMillis();
//
//        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
//
//        Method method = methodSignature.getMethod();
//
//        Metrics metrics = method.getAnnotation(Metrics.class);
//
//        String apiName = metrics.apiName();
//
//        MDC.put("API", apiName);
//        Object response;
//        try {
//            response = proceedingJoinPoint.proceed();
//        } finally {
//            long endTime = System.currentTimeMillis();
//
//            long responseTime = endTime - startTime;
//
//            log.info("API Response Time : {}", responseTime);
//
//            MDC.clear();
//        }
//        return response;
//    }
//
//
//}
