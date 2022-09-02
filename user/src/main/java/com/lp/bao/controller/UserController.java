package com.lp.bao.controller;

import com.lp.bao.feign.ConsumerService;
import com.lp.bao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RefreshScope
public class UserController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${user.my.username}")
    private String username;

    @Value("${user.my.password}")
    private String password;

    @Resource
    UserService userService;

    @Resource
    ConsumerService consumerService;

    @GetMapping("/user/{param}")
    public String test(@PathVariable("param") String param) {
       /* //使用 LoadBalanceClient 和 RestTemolate 结合的方式来访问
        ServiceInstance serviceInstance = loadBalancerClient.choose("consumer");
        String url = String.format("http://%s:%s/consumer/%s",serviceInstance.getHost(),serviceInstance.getPort(),appName + ":" +param);
        System.out.println("request url:"+url);
        return restTemplate.getForObject(url,String.class);*/
        return consumerService.test(param);
    }

    @GetMapping("/user/save")
    public int save() {
        return userService.saveEntity();
    }

    @GetMapping("/user/config")
    public String config() {

        return username + ":" + password;
    }
}
