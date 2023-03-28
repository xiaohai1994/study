package com.spring_s.myBatis.mybatis_spring;


import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Hai
 * @date 2023/3/28 上午8:20
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
//创建配置类给spring容器 进行注册当前bean
@Import(XiaoHai_ImportBeanDefinitionRegistrar.class)
public @interface XIaoHai_MapperScanner {

    String value();

}




