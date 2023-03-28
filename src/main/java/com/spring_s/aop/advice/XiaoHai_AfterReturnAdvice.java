package com.spring_s.aop.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author Hai
 * @date 2023/3/29 上午2:13
 *
 * proxy 执行类 在要执行的方法后进行执行
 */
public class XiaoHai_AfterReturnAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

        System.err.println("after");

    }
}
