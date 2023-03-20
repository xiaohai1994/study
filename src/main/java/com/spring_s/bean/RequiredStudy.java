package com.spring_s.bean;

import com.spring.service.Component;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Hai
 * @date 2023/3/20 上午10:27
 */


@Component
public class RequiredStudy {

    // @Autowired(required = false)  是否要进行强制注入 如果不需要强制注入这个值可以在spring容器中为nullBEAN
    @Autowired(required = false)
    private OrderService ordessrService;


}
