package com.gyan.darpan;

import com.gyan.darpan.dto.OrderDto;
import com.gyan.darpan.dto.UserDto;
import com.gyan.darpan.processor.EmployeeService;
import com.gyan.darpan.processor.InterviewProcessor;
import com.gyan.darpan.service.OrderService;
import com.gyan.darpan.service.UserProcessor;
import com.gyan.darpan.service.internal.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {
    private final OrderService orderService;
    private final UserProcessor userProcessor;
    private final PaymentService paymentService;
    private final EmployeeService employeeService;
    private final InterviewProcessor interviewProcessor;

    public DemoController(OrderService orderService, UserProcessor userProcessor, PaymentService paymentService, EmployeeService employeeService, InterviewProcessor interviewProcessor) {
        this.orderService = orderService;
        this.userProcessor = userProcessor;
        this.paymentService = paymentService;
        this.employeeService = employeeService;
        this.interviewProcessor = interviewProcessor;
    }

    @PostMapping("order")

    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        log.info("DemoController.createOrder()");
        return this.orderService.createOrder(orderDto);
    }

    @PostMapping("user")
    public UserDto createUser(@RequestBody UserDto userDto) {
        log.info("DemoController.createUser()");
        return this.userProcessor.addUser(userDto);
    }

    @PostMapping("payment")
    public String payment() {
        log.info("DemoController.payment()");

        paymentService.payment(23);

        return "Success";
    }

    @PostMapping("suffixDeclaringTypeDemo")
    public String suffixDeclaringTypeDemo() {
        log.info("DemoController.suffixDeclaringTypeDemo()");

        userProcessor.addUser(new UserDto());
        orderService.createOrder(new OrderDto());
        paymentService.payment(2);
        employeeService.addEmployee();
        interviewProcessor.takeInterview();

        return "Success";
    }

}
