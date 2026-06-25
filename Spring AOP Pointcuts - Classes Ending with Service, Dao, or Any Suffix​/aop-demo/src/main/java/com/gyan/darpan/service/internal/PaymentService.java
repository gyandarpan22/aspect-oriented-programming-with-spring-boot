package com.gyan.darpan.service.internal;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PaymentService {

    public void payment(double amount) {
        log.info("PaymentService.payment() : amount: {}", amount);
    }
}
