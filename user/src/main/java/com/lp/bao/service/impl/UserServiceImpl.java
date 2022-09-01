package com.lp.bao.service.impl;

import com.alibaba.fastjson.JSON;
import com.lp.bao.dao.UserMapper;
import com.lp.bao.entity.User;
import com.lp.bao.service.UserService;
import com.lp.bao.utill.RedisUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    private RedisUtils redisUtils;

    private RedissonClient redissonClient;

    @Override
    public String test() {
        User user = userMapper.findUserById(1);
        return user.getName();
    }

    @Override
    public int saveEntity() {
        User user1 = new User();
        user1.setName("james");
        int insert = userMapper.insert(user1);
        String key = user1.getId().toString();
        redisUtils.set(key,user1);
        User user =   redisUtils.get(key);
        System.out.println("================================================================");
        System.out.println(JSON.toJSONString(user));
        System.out.println("================================================================");


        RBucket<Object> redissonKey = redissonClient.getBucket("redissonKey");
        redissonKey.set("redissonValue");
        String value = (String)redissonKey.get();
        System.out.println(value + "=====================");
        return insert;
    }

    @Resource
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setRedisUtils(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Autowired
    public void setRedissonClient(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }
}
