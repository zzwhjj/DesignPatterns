package com.design.patterns.factory.abs;

public class Green implements Color{

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() methos");
    }
}
