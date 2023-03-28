package com.spring_s.myBatis.mybatis_spring;

import com.spring.service.Component;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;

import java.util.Set;

/**
 * @author Hai
 * @date 2023/3/28 上午8:51
 */
@Component
public class XiaoHai_Scanner extends ClassPathBeanDefinitionScanner {
    public XiaoHai_Scanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
        for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
            BeanDefinition beanDefinition = beanDefinitionHolder.getBeanDefinition();
            //给构造方法传值
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
            //将当前beanDefinition的beanClass的值改为工厂的方法
            beanDefinition.setBeanClassName(XiaoHai_FactoryBean.class.getName());
        }
        return beanDefinitionHolders;
    }


    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        //目标对象是否为interface当前beanDefinition
        return beanDefinition.getMetadata().isInterface();
    }
}
