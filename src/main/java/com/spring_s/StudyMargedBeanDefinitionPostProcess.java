package com.spring_s;

import com.spring_s.bean.OrderService;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author Hai
 * @date 2023/3/19 下午7:20
 */
@Component
public class StudyMargedBeanDefinitionPostProcess implements MergedBeanDefinitionPostProcessor {

    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        if (beanName.equals("userService")){
            System.err.println("这里是BeanDefintion 实例化后置处理器");
            beanDefinition.getPropertyValues().add("orderService",new OrderService());
        }
    }

}
