package com.lp.bao.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${consumer.name}")
    private String name;
    @Value("${consumer.passWord}")
    private String passWord;

    @GetMapping("consumer/{value}")
    public String test(@PathVariable("value") String value) {
        return value;
    }

    @GetMapping("/user/config")
    public String config() {

        return name + ":" + passWord;
    }
}
