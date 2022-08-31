package com.lp.bao.controller;

import com.lp.bao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/user/test")
    public String test() {
        return userService.test();
    }
    @GetMapping("/user/save")
    public int save() {
        return userService.saveEntity();
    }
}
