package com.design.patterns.single;

/**
 * 枚举，单例模式的最佳方法，更简洁，自动支持序列化机制，绝对防止多次实例化
 */
public enum SingletonEnum {

    INSTANCE;

    public void whateverMethod() {

    }
}
