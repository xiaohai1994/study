package com.spring_s.aop.advisor;

import com.spring_s.aop.UserService;
import com.spring_s.aop.advice.XiaoHai_MethodBeforeAdvice;
import org.aopalliance.aop.Advice;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcher;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author Hai
 * @date 2023/3/29 上午2:47
 *
 * advisor pointCut进行切点 使用 StaticMethodMatcherPointcut 进行切点验证，当前方法是否能够用于切点
 *
 * advice 构建一个用于切点后的执行过程
 */
public class XIaoHai_Proxy_PonintAdvisor implements PointcutAdvisor {

    //用来切点
    @Override
    public Pointcut getPointcut() {
        return new Pointcut() {
            @Override
            public ClassFilter getClassFilter() {
                return new ClassFilter() {
                    @Override
                    public boolean matches(Class<?> clazz) {
                        return clazz.equals(UserService.class);
                    }
                };

            }
            @Override
            public MethodMatcher getMethodMatcher() {
                return new MethodMatcher() {
                    @Override
                    public boolean matches(Method method, Class<?> targetClass) {
                        return method.getName().equals("test");
                    }
                    @Override
                    public boolean isRuntime() {
                        return false;
                    }

                    @Override
                    public boolean matches(Method method, Class<?> targetClass, Object... args) {
                        return false;
                    }
                };
            }
        };
    }

    //执行过程
    @Override
    public Advice getAdvice() {
        return new XiaoHai_MethodBeforeAdvice();
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }
}
