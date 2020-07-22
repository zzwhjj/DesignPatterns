package com.design.patterns.single;

/**
 * 单例模式
 */
public class SingleObject {

    private static SingleObject instance = new SingleObject();

    private SingleObject(){

    }

    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}
