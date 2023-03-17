
package com.spring.service;

public interface BeanPostProcessor {

	default Object postProcessBeforeInitialization(Object bean, String beanName)  {
		return bean;
	}
	default Object postProcessAfterInitialization(Object bean, String beanName)  {
		return bean;
	}

}