package com.spring_s.aop.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author Hai
 * @date 2023/3/29 上午2:15
 *
 * 代理执行过程 当抛出异常的时候执行
 */
public class XiaoHai_ThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
        System.err.println("throws");
    }


}
