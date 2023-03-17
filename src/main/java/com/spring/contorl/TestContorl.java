package com.spring.contorl;

import com.spring.UserService;
import com.spring.UserServiceImp;
import com.spring.service.Autowired;

public class TestContorl {


    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceImp userServiceImp;


    public void println(){
        System.err.println(userService);
        System.err.println(userServiceImp);
    }




}
