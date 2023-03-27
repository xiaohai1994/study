package com.spring_s.myBatis;

import org.springframework.stereotype.Component;


/**
 * @author Hai
 * @date 2023/3/25 下午6:01
 */
@Component
public class User {


    private int id;

    private int age;

    private String name;

//    @Autowired
//    UserService userService ;

    public void test(){
//        System.err.println(userService.getUsers());
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
