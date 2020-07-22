package com.design.abstractfactory;

/**
 * 抽象工厂
 */
public abstract class AbastractFactory {

    protected abstract Food createFood();
    abstract Vehicle createVehicle();
    abstract Weapon createWeapn();
}
