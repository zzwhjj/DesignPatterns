package com.design.patterns.factory.abs;

/**
 * 使用FactoryProducer来获取AbstractFactory, 通过传递类型信息来获取实体类的对象
 */
public class AbstractFactoryPatternDemo {

    public static void main(String[] args) {
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");

        Shape s1 = shapeFactory.getShape("circle");
        s1.draw();

        Shape s2 = shapeFactory.getShape("rectangle");
        s2.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color c1 = colorFactory.getColor("red");
        c1.fill();
    }

}
