package com.design.patterns.factory.abs;

/**
 * 创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("shape")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("color")) {
            return new ColorFactory();
        }
        return null;
    }
}
