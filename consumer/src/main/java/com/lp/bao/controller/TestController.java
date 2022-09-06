package com.lp.bao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {
    @Value("${consumer.name}")
    private String name;
    @Value("${consumer.passWord}")
    private String passWord;

    @GetMapping("consumer/{value}")
    public String test(@PathVariable("value") String value) {
        System.out.println("===========================>");
        return value;
    }

    @GetMapping("/user/config")
    public String config() {
        log.info("info===========>{}", "info Level");
        log.debug("debug===========>{}", "debug Level");
        log.error("error===========>{}", "error Level");
        log.warn("warn===========>{}", "warn Level");
        return name + ":" + passWord;
    }
}
