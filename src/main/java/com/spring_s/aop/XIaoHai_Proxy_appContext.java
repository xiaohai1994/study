package com.spring_s.aop;
import com.spring.service.Component;
import com.spring_s.aop.advice.XiaoHai_MethodBeforeAdvice;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * @author Hai
 * @date 2023/3/29 上午3:21
 */


@ComponentScan("com.spring_s.aop")
//@EnableAspectJAutoProxy
@Import(DefaultAdvisorAutoProxyCreator.class)
public class XIaoHai_Proxy_appContext {



    //初始化后如果要进行aop就会执行aop的相应beanPostProcess 并且会有 DefaultAdvisorAutoProxyCreator 来执处理这个bean
    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor(){
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("test");
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        defaultPointcutAdvisor.setPointcut(pointcut);
        defaultPointcutAdvisor.setAdvice(new XiaoHai_MethodBeforeAdvice());
        return defaultPointcutAdvisor;
    }
//    @Bean
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new
//                DefaultAdvisorAutoProxyCreator();
//        return defaultAdvisorAutoProxyCreator;
//    }

    //这是一个beanPostProcess//用来支持解析 DefaultPointcutAdvisor
//    @Bean
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
//        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//        return defaultAdvisorAutoProxyCreator;
//    }
//
//
//    @Bean
//    public DefaultPointcutAdvisor defaultPointcutAdvisor (){
//        //得到一个默认的advisor 将执行过程和切点添加进去。
//        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
//        //获取到一个切点对象
//        NameMatchMethodPointcut nameMatchMethodPointcut = new NameMatchMethodPointcut();
//        nameMatchMethodPointcut.addMethodName("test");
//        defaultPointcutAdvisor.setPointcut(nameMatchMethodPointcut);
//        defaultPointcutAdvisor.setAdvice(new XiaoHai_MethodBeforeAdvice());
//        return defaultPointcutAdvisor;
//    }



}
