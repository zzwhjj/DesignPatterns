package com.design.patterns.prototype;

public class Rectangle extends Shape{

    public Rectangle() {
        type = "Recangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method");
    }
}
