package com.design.patterns.single;

/**
 * 饿汉式，类加载时即初始化，浪费内存，容易产生垃圾对象
 */
public class SingletonHungry {

    private static SingletonHungry instance = new SingletonHungry();
    private SingletonHungry(){}

    public static SingletonHungry getInstance() {
        return instance;
    }
}
