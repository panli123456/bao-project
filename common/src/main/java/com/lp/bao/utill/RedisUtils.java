package com.lp.bao.utill;

import com.lp.bao.config.RedisConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@ConditionalOnBean(RedisConfig.class)
public class RedisUtils {

    @Resource(name = "redisTemplate1")
    RedisTemplate<String, Object> redisTemplate;

    public int set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
        return 1;
    }

    public <T> T get(String key) {
        T o = (T) redisTemplate.opsForValue().get(key);
        return o;
    }

}
