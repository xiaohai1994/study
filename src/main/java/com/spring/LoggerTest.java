package com.spring;

public class LoggerTest extends NativeLogger {

    public LoggerTest(Class clazz) {
        super(clazz);
    }

    public void testLogger(){
        getLogger().trace(this);
    }
}
