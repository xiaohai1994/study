package com.spring_s.myBatis;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Hai
 * @date 2023/3/25 下午6:04
 */
public interface UserDao {
    @Select("selet * from user")
    public List<User> getUsers();

}
