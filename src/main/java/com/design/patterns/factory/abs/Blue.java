package com.design.patterns.factory.abs;

public class Blue implements Color{

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() methos");
    }
}
