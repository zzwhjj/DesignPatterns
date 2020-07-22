package com.design.patterns.factory;

//使用该工厂，通过传递类型信息来获取实体类的对象
public class FactoryPatternDemo {

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        
        Shape shape1 = factory.getShape("circle");
        shape1.draw();

        Shape shape2 = factory.getShape("rectangle");
        shape2.draw();

        Shape shape3 = factory.getShape("square");
        shape3.draw();
    }
}
