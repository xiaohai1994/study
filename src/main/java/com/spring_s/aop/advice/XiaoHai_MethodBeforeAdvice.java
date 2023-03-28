package com.spring_s.aop.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author Hai
 * @date 2023/3/29 上午2:10
 *
 * advice代理类的执行过程。XiaoHai_ProxyFactory.class 在执行要执行方法之前进行切面执行
 */
public class XiaoHai_MethodBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.err.println("bfore");
    }
}


