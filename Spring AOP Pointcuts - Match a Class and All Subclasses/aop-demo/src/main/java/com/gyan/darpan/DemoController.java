package com.gyan.darpan;

import com.gyan.darpan.dto.OrderDto;
import com.gyan.darpan.dto.UserDto;
import com.gyan.darpan.service.OrderService;
import com.gyan.darpan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {
    private final OrderService orderService;
    private final UserService userService;

    @Autowired
    public DemoController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping("order")
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        log.info("DemoController.createOrder()");
        return this.orderService.createOrder(orderDto);
    }

    @PostMapping("user")
    public UserDto createUser(@RequestBody UserDto userDto) {
        log.info("DemoController.createUser()");
        return this.userService.addUser(userDto);
    }
}
