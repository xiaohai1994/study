package com.spring;

import com.spring.service.Autowired;
import com.spring.service.Component;
import com.spring.service.PourInto;
import com.spring.service.Scope;

@Component
@Scope(type = "prototype")
public class User implements UserInterFace{

    private int id ;

    @Autowired
    UserService userService;

    @Autowired
    UserServiceImp userServiceImp;

    @PourInto(value = "小海哥")
    String xiaohaige;
    public void println(){
        NativeLogger.logger(xiaohaige);
    }


    @Override
    public void print() {
        NativeLogger.logger("heiha");
    }
}
