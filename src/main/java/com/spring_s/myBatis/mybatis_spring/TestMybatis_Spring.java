package com.spring_s.myBatis.mybatis_spring;

import com.spring_s.myBatis.mapper.UserMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.jupiter.api.Test;

/**
 * @author Hai
 * @date 2023/3/28 上午8:06
 */
public class TestMybatis_Spring {

    @Test
    public void testMybatis_Spring(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MybatisConText.class);
//        for (String beanDefinitionName : annotationConfigApplicationContext.getBeanDefinitionNames()) {
//            System.err.println(beanDefinitionName);
//        }
//
        UserService userService = (UserService) annotationConfigApplicationContext.getBean("userService");
//        System.err.println(annotationConfigApplicationContext.getBean("xiaoHai_FactoryBean"));
        userService.testUserMapper();
    }

}
