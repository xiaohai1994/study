package com.spring_s.myBatis;

import com.spring_s.myBatis.mybatis_spring.MybatisConText;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Hai
 * @date 2023/3/28 上午6:11
 */
public class Test_Mybatis {

    public static void main(String[] args) throws IOException {


//        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
//
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        sqlSessionFactory.getConfiguration().addMapper(UserDao.class);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserDao mapper = sqlSession.getMapper(UserDao.class);
//        User user = new User();
//        user.setId(1);
//        user.setName("xiaohai");
//        user.setAge(28);
//        int i = mapper.insertUser(user);
//        System.err.println(1);
//        List<User> users = mapper.getUsers();
//        System.err.println(users);
//        sqlSession.commit();
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MybatisConText.class);


    }

}
