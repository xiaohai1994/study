package com.spring;

import com.spring.service.Autowired;
import com.spring.service.Component;

@Component
public class UserServiceImp {

    @Autowired
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
