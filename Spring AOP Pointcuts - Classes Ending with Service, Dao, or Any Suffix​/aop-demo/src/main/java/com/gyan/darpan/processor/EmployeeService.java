package com.gyan.darpan.processor;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EmployeeService {
    public void addEmployee() {
        log.info("EmployeeService.addEmployee()");
    }
}
