package com.design.patterns.single;

/**
 * 懒汉式，线程安全，每次都加锁，影响效率
 */
public class SingletonLazySafe {

    private static SingletonLazySafe instance;
    private SingletonLazySafe(){}

    public static synchronized SingletonLazySafe getInstance() {
        if (instance == null) {
            instance = new SingletonLazySafe();
        }
        return instance;
    }
}
