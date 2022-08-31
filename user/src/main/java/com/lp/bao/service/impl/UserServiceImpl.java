package com.lp.bao.service.impl;

import com.lp.bao.dao.UserMapper;
import com.lp.bao.entity.User;
import com.lp.bao.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
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
        return insert;
    }
}
