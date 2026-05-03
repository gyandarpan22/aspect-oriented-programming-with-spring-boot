package com.gyan.darpan.controller;

import com.gyan.darpan.dto.Order;
import com.gyan.darpan.dto.PremiumUser;
import com.gyan.darpan.dto.UserDto;
import com.gyan.darpan.service.DemoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
@Log4j2
public class DemoController {
    private final DemoService demoService;
    private final ModifierDemo modifierDemo;

    public DemoController(DemoService demoService, ModifierDemo modifierDemo) {
        this.demoService = demoService;
        this.modifierDemo = modifierDemo;
    }

    @GetMapping
    public String displayMessage(
            @RequestParam("userName") String userName,
            @RequestParam("age") int age,
            @RequestParam("message") String message,
            @RequestParam("count") int count
    ) {
        log.info("Inside DemoController:displayMessage() , demoService : {}", demoService.getClass());

        demoService.createUser(new UserDto(userName, age), message, count);

        PremiumUser user = PremiumUser.builder()
                .name(userName)
                .age(age)
                .premiumFeature("premiumFeature")
                .build();
        demoService.premiumCreateUser(user, message, count);

        demoService.createOrder(Order.builder().orderId(123).build());

        return demoService.displayMessage(new UserDto(userName, age), message, count);
    }

    @GetMapping("modiferDemo")
    public String modiferDemo() {
        log.info("Inside DemoController:modiferDemo() , modifierDemo : {}", modifierDemo.getClass());

        modifierDemo.displayMessage();
        modifierDemo.protectedDisplayMessage();

        return "Success";
    }
}
