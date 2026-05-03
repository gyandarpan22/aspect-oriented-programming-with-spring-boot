package com.gyan.darpan.service;

import com.gyan.darpan.dto.Order;
import com.gyan.darpan.dto.PremiumUser;
import com.gyan.darpan.dto.UserDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class DemoService {

    public String displayMessage(UserDto user, String message, int count) {
        log.info("Inside DemoService:displayMessage()");

        return String.format("User : %s , Message : %s , Count :%d", user.toString(), message, count);
    }

    public UserDto createUser(UserDto user, String message, int count) {
        log.info("Inside DemoService:createUser()");

        return user;
    }

    public PremiumUser premiumCreateUser(PremiumUser user, String message, int count) {
        log.info("Inside DemoService:premiumCreateUser()");

        return user;
    }

    public Order createOrder(Order order) {
        log.info("Inside DemoService:createOrder()");

        return order;
    }

}
