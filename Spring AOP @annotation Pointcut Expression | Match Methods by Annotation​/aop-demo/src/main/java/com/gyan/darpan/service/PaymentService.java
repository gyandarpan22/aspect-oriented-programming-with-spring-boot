package com.gyan.darpan.service;

import com.gyan.darpan.aspect.annotation.LogExecution;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PaymentService {

    @LogExecution(value = "processPayment")
    public void processPayment() {
        log.info("PaymentService.processPayment()");
    }

    public void generateReport() {
        log.info("PaymentService.generateReport()");
    }

}
