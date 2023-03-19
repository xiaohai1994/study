package com.spring_s.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
/**
 * @author Hai
 * @date 2023/3/19 下午7:31
 */
@Component
public class UserService {

    @Autowired
    private OrderService orderService;

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void test(){
        System.err.println(orderService);
    }

}
