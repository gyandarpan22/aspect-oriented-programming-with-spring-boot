package com.gyan.darpan.service;

import com.gyan.darpan.aspect.annotation.LogExecution;
import com.gyan.darpan.aspect.annotation.Metrics;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Log4j2
public class PaymentService {

    @LogExecution(value = "processPayment")
    @Metrics(apiName = "ProcessPayment")
    public int processPayment() throws IOException {
        log.info("PaymentService.processPayment()");

        return 10;
    }

}
