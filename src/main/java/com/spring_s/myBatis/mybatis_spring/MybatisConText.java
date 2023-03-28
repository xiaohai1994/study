package com.spring_s.myBatis.mybatis_spring;

import com.spring.service.Component;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Hai
 * @date 2023/3/28 上午8:02
 */

@XIaoHai_MapperScanner("com.spring_s.myBatis.mapper")
@ComponentScan("com.spring_s.myBatis")
public class MybatisConText {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }


}
