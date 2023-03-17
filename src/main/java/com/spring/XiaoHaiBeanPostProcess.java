package com.spring;

import com.spring.service.BeanPostProcessor;
import com.spring.service.Component;
import com.spring.service.PourInto;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class XiaoHaiBeanPostProcess implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {


        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {

            for (Field field : bean.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(PourInto.class)){
                    try {
                        field.setAccessible(true);
                        field.set(bean,field.getAnnotation(PourInto.class).value());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        return bean;
    }
}
