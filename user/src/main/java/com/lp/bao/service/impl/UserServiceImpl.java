package com.lp.bao.service.impl;

import com.alibaba.fastjson.JSON;
import com.lp.bao.dao.UserMapper;
import com.lp.bao.entity.User;
import com.lp.bao.service.UserService;
import com.lp.bao.utill.RedisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Resource
    RedisUtils redisUtils;

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
        return insert;
    }
}
