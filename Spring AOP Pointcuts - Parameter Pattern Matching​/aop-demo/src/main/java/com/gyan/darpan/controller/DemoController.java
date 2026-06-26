package com.gyan.darpan.controller;

import com.gyan.darpan.service.ParamPatternService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class DemoController {

    private ParamPatternService paramPatternService;

    public DemoController(ParamPatternService paramPatternService) {
        this.paramPatternService = paramPatternService;
    }

    @GetMapping("paramPatternDemo")
    public String paramPatternDemo() {

        paramPatternService.noArgsMethod();
        paramPatternService.stringArgsMethod("str1");
        paramPatternService.intArgsMethod(1);

        paramPatternService.twoArgsMethodWithStringAndInteger("Str2", 1);
        paramPatternService.twoArgsMethodWithStringAndDouble("str3", 2d);
        paramPatternService.twoArgsMethodWithIntegerAndInteger(4, 5);

        return "Success";
    }
}
