package com.gyan.darpan.service;

import com.gyan.darpan.dto.UserDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserService {

    public UserDto addUser(UserDto userDto) {
        log.info("UserService.addUser()");

        return userDto;
    }
}
