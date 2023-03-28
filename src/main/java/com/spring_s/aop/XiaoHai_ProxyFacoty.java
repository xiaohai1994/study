package com.spring_s.aop;


import com.spring_s.aop.advice.XiaoHai_AfterReturnAdvice;
import com.spring_s.aop.advice.XiaoHai_AroundAdvice;
import com.spring_s.aop.advice.XiaoHai_MethodBeforeAdvice;
import com.spring_s.aop.advice.XiaoHai_ThrowsAdvice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @author Hai
 * @date 2023/3/29 上午2:03
 *
 * ProxyFactory 是spring.aop包下的 可以再spring的项目中直接使用
 */
public class XiaoHai_ProxyFacoty {

    public static void main(String[] args) {

        UserService userService = new UserService();

        ProxyFactory proxyFactory = new ProxyFactory();
        //设置要代理的对象
        proxyFactory.setTarget(userService);
        //设置接口 如果设置接口，那么就使用jdk的动态代理
//        proxyFactory.setInterfaces(UserServiceInterface.class);
        //添加代理行为 ，要做的切面行为
//        proxyFactory.addAdvice(new MethodBeforeAdvice() {
//            @Override
//            public void before(Method method, Object[] args, Object target) throws Throwable {
//                System.err.println("before");
//            }
//        });
        //添加执行过程advic // 在源码中这三个都为 MthodIntercpet
        proxyFactory.addAdvice(new XiaoHai_MethodBeforeAdvice());
        proxyFactory.addAdvice(new XiaoHai_AfterReturnAdvice());
        proxyFactory.addAdvice(new XiaoHai_ThrowsAdvice());
        proxyFactory.addAdvice(new XiaoHai_AroundAdvice());
        //获取代理对象
        UserService proxy = (UserService) proxyFactory.getProxy();
        proxy.a();
        proxy.test();

    }
}
