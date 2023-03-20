package com.executorsstudy;

import com.spring_s.bean.AppContext;
import com.spring_s.bean.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Hai
 * @date 2023/3/20 上午8:50
 */
public class ExecutorStudy {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService executorService = new ThreadPoolExecutor(0,Integer.MAX_VALUE,60, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10000000));
        final int[] index = {0};
        final long[] time ={System.currentTimeMillis()};

        for (;;) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    index[0]++;
                        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppContext.class);
                        UserService userService = (UserService) annotationConfigApplicationContext.getBean("userService");
                        userService.test();
                    System.err.println("嘿嘿嘿" + index[0] + "   ");
                    if ( index[0] >= 100000){
                        System.err.println(System.currentTimeMillis() - time[0]);
                        executorService.shutdown();
                    }
                }
            });
        }


        //会执行完队列中的任务才会停止
//        executorService.shutdown();
        //直接将状态改为Stop
//        executorService.shutdownNow();

    }

}
