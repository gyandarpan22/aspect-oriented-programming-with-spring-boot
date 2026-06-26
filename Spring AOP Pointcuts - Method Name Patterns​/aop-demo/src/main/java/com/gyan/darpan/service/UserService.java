package com.gyan.darpan.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserService {

    public void addUser(String userName) {
        log.info("UserService.addUseer() : {}", userName);
    }

    public void getUser(int userId) {
        log.info("UserService.getUser() : {}", userId);
    }

    public void get(int userId) {
        log.info("UserService.get() : {}", userId);
    }
}
