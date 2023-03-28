package com.spring_s.aop;


import org.springframework.stereotype.Component;

/**
 * @author Hai
 * @date 2023/3/29 上午1:16
 */
@Component
public class UserService {

    public void test(){
        System.err.println("test");
    }

    public void a(){
        System.err.println("a");
//        throw new NullPointerException();
    }

}
