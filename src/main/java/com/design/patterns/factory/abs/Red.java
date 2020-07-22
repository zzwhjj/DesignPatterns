package com.design.patterns.factory.abs;

public class Red implements Color{

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() methos");
    }
}
