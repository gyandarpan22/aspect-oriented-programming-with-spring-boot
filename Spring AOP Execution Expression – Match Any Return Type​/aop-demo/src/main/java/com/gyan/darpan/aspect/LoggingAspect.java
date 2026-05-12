package com.gyan.darpan.aspect;


import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log4j2
public class LoggingAspect {

    @Before("execution(* com.gyan.darpan.service.DemoService.*(..))")
    public void aspectDemo(JoinPoint joinPoint) {

        log.info("Inside LoggingAspect.aspectDemo()");

        //First get Signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        //method Name
        log.info("Inside LoggingAspect.aspectDemo() : Method Name : {}", methodSignature.getName());

        //className
        log.info("Inside LoggingAspect.aspectDemo() : Class Name : {}", methodSignature.getDeclaringTypeName());

        //Return Type
        log.info("Inside LoggingAspect.aspectDemo() : Return Type : {}", methodSignature.getReturnType());


        //Modifier
//        log.info("Inside LoggingAspect.beforeDisplayMessage() : Modifier : {}", Modifier.toString(methodSignature.getModifiers()));
//
//        String[] parameterNames = methodSignature.getParameterNames();
//
//        Class<?>[] parameterTypes = methodSignature.getParameterTypes();
//
//        int argsCount = parameterNames.length;
//
//        log.info("Inside LoggingAspect.beforeDisplayMessage() : Args Count : {}", argsCount);
//
//        Object[] argsValue = joinPoint.getArgs();
//
//        for (int i = 0; i < argsCount; i++) {
//            log.info("Inside LoggingAspect.beforeDisplayMessage() : parameterName : {}, " +
//                    "parameterType : {} , Value : {}", parameterNames[i], parameterTypes[i].getName(), argsValue[i]);
//        }
    }
}
