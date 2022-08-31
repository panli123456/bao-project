package com.lp.bao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lp.bao.entity.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper extends BaseMapper<User> {

    User findUserById(@Param("id") Integer id);

}
