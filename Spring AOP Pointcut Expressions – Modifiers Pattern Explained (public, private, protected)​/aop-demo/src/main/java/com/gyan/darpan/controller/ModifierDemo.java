package com.gyan.darpan.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ModifierDemo {

    public void displayMessage() {
        log.info("ModifierDemo.displayMessage() called");
    }

    protected void protectedDisplayMessage() {
        log.info("ModifierDemo.protectedDisplayMessage() called");
    }
}
