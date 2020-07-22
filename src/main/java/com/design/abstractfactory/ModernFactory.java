package com.design.abstractfactory;

/**
 * 具体工厂
 */
public class ModernFactory extends AbastractFactory{

    @Override
    protected Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapn() {
        return new AK47();
    }
}
