package com.spring_s.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Hai
 * @date 2023/3/29 上午2:21
 */
public class XiaoHai_AroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.err.println("Around : before");
        //执行。
        Object proceed = invocation.proceed();
        System.err.println("Around : after");
        return proceed;
    }
}
