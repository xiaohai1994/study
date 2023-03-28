package com.spring_s.aop;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Hai
 * @date 2023/3/29 上午3:27
 */
public class XIaoHai_Test_Proxy_Advisor_AutowriedBean {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(XIaoHai_Proxy_appContext.class);
        UserService userService = (UserService) annotationConfigApplicationContext.getBean("userService");
        userService.a();

    }

} 1 33 35
