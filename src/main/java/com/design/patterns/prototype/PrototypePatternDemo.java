package com.design.patterns.prototype;

public class PrototypePatternDemo {

    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape = (Shape)ShapeCache.getShape("1");
        System.out.println("shape: " + clonedShape.getType());

        Shape shape2 = (Shape)ShapeCache.getShape("2");
        System.out.println("Shape：" + shape2.getType());

        Shape shape3 = (Shape)ShapeCache.getShape("3");
        System.out.println("Shape: " + shape3.getType());
    }
}
