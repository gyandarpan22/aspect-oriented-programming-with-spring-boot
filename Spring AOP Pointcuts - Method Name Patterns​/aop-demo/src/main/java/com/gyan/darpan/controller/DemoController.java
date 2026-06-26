package com.gyan.darpan.controller;

import com.gyan.darpan.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class DemoController {
    private final UserService userService;

    public DemoController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("aopMethodDemo")
    public String aopMethodDemo() {

        userService.addUser("AOP User");
        userService.getUser(1);
        userService.get(2);

        return "Success";
    }
}
