package com.gyan.darpan.processor;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class InterviewProcessor {
    public void takeInterview(){
        log.info("InterviewProcessor.takeInterview()");
    }
}
