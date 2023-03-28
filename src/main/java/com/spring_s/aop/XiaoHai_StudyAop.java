package com.spring_s.aop;

import org.springframework.cglib.proxy.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Hai
 * @date 2023/3/29 上午1:10
 */
public class XiaoHai_StudyAop {

     public static void main(String[] args) {
         UserService target = new UserService();

         //增强器
         Enhancer enhancer = new Enhancer();

         //设置要代理的对象class
         enhancer.setSuperclass(UserService.class);

         //定义代理逻辑
         enhancer.setCallbacks(new Callback[]{new MethodInterceptor() {
             @Override
             public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                 System.err.println("代理对象：参数 o");
                 System.err.println("method 参数" + method.getName());
                 System.err.println("要执行的方法前");
                 //设置要执行哪一个类的方法 并返回一个invoke对象
                 Object invoke = methodProxy.invoke(target, objects);
                 System.err.println("要执行的方法后");
                 return invoke;
             }
         },NoOp.INSTANCE});

         //使用责任链模式限制其他方法 要使用 NoOp.INSTANCE这个拦截器下面的拦截器才会生效
         enhancer.setCallbackFilter(new CallbackFilter() {
             @Override
             public int accept(Method method) {
                 if (method.getName().equals("test")) return 0;
                 return 1;
             }
         });

        UserService userService = (UserService) enhancer.create();
        userService.test();
        userService.a();

        //jdk 动态代理--------------------------------
         UserServiceInterface o = (UserServiceInterface) Proxy.newProxyInstance(XiaoHai_StudyAop.class.getClassLoader(), new Class[]{UserServiceInterface.class}, new InvocationHandler() {
             @Override
             public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                 Object invoke = method.invoke(target, args);

                 return invoke;
             }
         });

        o.test();


     }

}
