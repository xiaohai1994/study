package com.spring.service;

public class DeFinition {

    private String type;

    private String name;

    private Class clazz;

    public DeFinition() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public DeFinition(String type, String name, Class clazz) {
        this.type = type;
        this.name = name;
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "DeFinition{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}
