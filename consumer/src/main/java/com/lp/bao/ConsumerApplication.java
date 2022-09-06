package com.lp.bao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication {
    public static void main(String[] args) {
       // System.setProperty("nacos.logging.default.config.enabled","false");

        SpringApplication.run(ConsumerApplication.class);
    }
}
