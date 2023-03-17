package com.spring;

import org.apache.log4j.Logger;

public class NativeLogger {

    Class clazz = null;
    Logger logger =null;
    public NativeLogger(Class clazz) {
        this.clazz = clazz;
        logger = Logger.getLogger(clazz);
    }

    public Logger getLogger() {
        return logger;
    }

    public static void logger(Object str){
        System.err.println(str.toString());
    }
}
