package com.gyan.darpan.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ParamPatternService {

    public void noArgsMethod(){
        log.info("ParamPatternService.noArgsMethod()");
    }

    public void stringArgsMethod(String str){
        log.info("ParamPatternService.stringArgsMethod() :: {}",str);
    }

    public void intArgsMethod(int int1){
        log.info("ParamPatternService.intArgsMethod() :: {}",int1);
    }

    public void twoArgsMethodWithStringAndInteger(String str,Integer int1){
        log.info("ParamPatternService.twoArgsMethodWithStringAndInteger() :: {} ,{}",str,int1);
    }

    public void twoArgsMethodWithStringAndDouble(String str,Double doubl1){
        log.info("ParamPatternService.twoArgsMethodWithStringAndDouble() :: {} ,{}",str,doubl1);
    }

    public void twoArgsMethodWithIntegerAndInteger(Integer int1,Integer int2){
        log.info("ParamPatternService.twoArgsMethodWithIntegerAndInteger() :: {} ,{}",int1,int2);
    }



}
