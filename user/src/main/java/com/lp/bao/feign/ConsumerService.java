package com.lp.bao.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "consumer")
public interface ConsumerService {
    @GetMapping("consumer/{value}")
    public String test(@PathVariable("value") String value);
}
