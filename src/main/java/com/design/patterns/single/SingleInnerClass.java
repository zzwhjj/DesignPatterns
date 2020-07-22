package com.design.patterns.single;

/**
 * 登记式/静态内部类，跟双检锁一样的功效，但实现简单
 */
public class SingleInnerClass {

    private static class SingletonHolder {
        private static final SingleInnerClass INSTANCE = new SingleInnerClass();
    }
    private SingleInnerClass(){}
    public static final SingleInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
