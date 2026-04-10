package com.gyan.darpan.controller;

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

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping
    public String displayMessage(
            @RequestParam("userName") String userName,
            @RequestParam("age") int age,
            @RequestParam("message") String message,
            @RequestParam("count") int count
    ) {
        log.info("Inside DemoController:displayMessage() , demoService : {}", demoService.getClass());

        return demoService.displayMessage(new UserDto(userName, age), message, count);
    }
}
