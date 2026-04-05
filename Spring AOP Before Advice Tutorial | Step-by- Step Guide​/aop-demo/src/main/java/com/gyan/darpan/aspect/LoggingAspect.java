package com.gyan.darpan.aspect;


import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log4j2
public class LoggingAspect {

    @Before("execution(public void com.gyan.darpan.service.DemoService.displayMessage())")
    public void beforeDisplayMessage() {
        log.info("Inside LoggingAspect : beforeDisplayMessage()");
    }
}
