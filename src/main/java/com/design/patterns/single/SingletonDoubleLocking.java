package com.design.patterns.single;

/**
 * 双检锁/双重校验锁，实现复杂，多线程安全且能保证效率
 */
public class SingletonDoubleLocking {

    private volatile static SingletonDoubleLocking instance;
    private SingletonDoubleLocking(){}

    public static SingletonDoubleLocking getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleLocking.class) {
                if (instance == null) {
                    instance = new SingletonDoubleLocking();
                }
            }
        }
        return instance;
    }
}
