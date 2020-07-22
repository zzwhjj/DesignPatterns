package com.design.abstractfactory;

/**
 * 具体工厂
 */
public class MagicFactory extends AbastractFactory {

    @Override
    protected Food createFood() {
        return new Mush();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapn() {
        return new MagicStick();
    }
}
