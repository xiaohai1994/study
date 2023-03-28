package com.spring_s.aop.advisor;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;

/**
 * @author Hai
 * @date 2023/3/29 上午2:41
 *
 * advice 和 pointcut 属于 advisor
 *
 *
 */
public class XiaoHai_ProxAdvisor implements Advisor {

    @Override
    public Advice getAdvice() {
        return null;
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }
}
