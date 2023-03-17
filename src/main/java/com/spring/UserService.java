package com.spring;

import com.spring.service.Autowired;
import com.spring.service.Component;
import com.spring.service.InitializingBean;
import com.spring.service.Scope;

@Component
@Scope
public class UserService implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        NativeLogger.logger("UserService 初始化后");
    }

}
