package com.design.patterns.prototype;

public class Square extends Shape{

    public Square() {
        type = "Sqaure";
    }

    @Override
    public void draw() {
        System.out.println("Inside Sqaure::draw() method");
    }
}
