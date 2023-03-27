package com.spring_s.myBatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Hai
 * @date 2023/3/28 上午6:11
 */
public class Test_Mybatis {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        for (User user : mapper.getUsers()) {
            System.err.println(user);
        }
    }

}
