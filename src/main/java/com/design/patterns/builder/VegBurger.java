package com.design.patterns.builder;

/**
 * Burger的实体类
 */
public class VegBurger extends Burger {

    @Override
    public String name() {
        return "veg burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
