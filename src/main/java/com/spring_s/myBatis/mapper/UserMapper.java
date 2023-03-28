package com.spring_s.myBatis.mapper;

import com.spring_s.myBatis.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Hai
 * @date 2023/3/25 下午6:04
 */
public interface UserMapper {
    @Select("select * from user")
    public List<User> getUsers();

    @Insert("insert into user(id,name,age) values(#{id},#{name},#{age})")
    public int insertUser(User user);


}
