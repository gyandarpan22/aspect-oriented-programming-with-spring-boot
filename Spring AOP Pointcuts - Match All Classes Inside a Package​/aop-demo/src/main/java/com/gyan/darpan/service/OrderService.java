package com.gyan.darpan.service;

import com.gyan.darpan.dto.OrderDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class OrderService {

    public OrderDto createOrder(OrderDto orderDto) {
        log.info("OrderService.createOrder()");

        return orderDto;
    }
}
