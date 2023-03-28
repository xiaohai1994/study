package com.spring_s.myBatis.mybatis_spring;

import com.spring_s.myBatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Hai
 * @date 2023/3/28 上午9:59
 */


@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public void testUserMapper(){
        System.err.println(userMapper.getUsers());
    }



}
