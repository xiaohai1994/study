package com.spring_s;

import com.spring_s.bean.OrderService;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Hai
 * @date 2023/3/19 下午7:20
 */
@Component
public class StudyInstallBefaul implements InstantiationAwareBeanPostProcessor {


    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanName.equals("userService")){
            System.err.println("这里是实例化前置处理器");
        }
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (beanName.equals("userService")) {
            System.err.println("这里是实例化后置处理器");
        }
        return true;
    }

    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.err.println("注入点");
        return null;
    }
}
