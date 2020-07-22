package com.design.patterns.single;

/**
 * 懒汉式，线程不安全
 */
public class SingletonLazyNotSafe {

    private static SingletonLazyNotSafe instance;
    private SingletonLazyNotSafe(){}

    public static SingletonLazyNotSafe getInstance() {
        if (instance == null) {
            instance = new SingletonLazyNotSafe();
        }
        return instance;
    }
}
