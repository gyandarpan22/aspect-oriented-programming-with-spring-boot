package com.gyan.darpan.controller;

import com.gyan.darpan.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Log4j2
public class DemoController {

    private final PaymentService paymentService;

    public DemoController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("demo")
    public String demo() {
        try {
            paymentService.processPayment();
        } catch (IOException e) {

        }


        return "Success";
    }
}
