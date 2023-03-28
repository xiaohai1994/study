package com.spring_s.aop;

import com.spring_s.aop.advisor.XIaoHai_Proxy_PonintAdvisor;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author Hai
 * @date 2023/3/29 上午2:40
 */
public class XiaoHai_ProxyFoctoryAdvisor {

    public static void main(String[] args) {

        UserService userService = new UserService();

        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(userService);

        proxyFactory.addAdvisor(new XIaoHai_Proxy_PonintAdvisor());

        UserService proxy = (UserService) proxyFactory.getProxy();
        proxy.test();

    }



}
