package com.gyan.darpan.controller;

import com.gyan.darpan.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class DemoController {

    private final PaymentService paymentService;

    public DemoController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("annotationAopDemo")
    public String annotationAopDemo() {
        paymentService.processPayment();
        paymentService.generateReport();

        return "Success";
    }
}
