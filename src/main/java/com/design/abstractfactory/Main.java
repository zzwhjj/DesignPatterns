package com.design.abstractfactory;

public class Main {

    public static void main(String[] args) {
        AbastractFactory factory = new ModernFactory();

        Vehicle car = factory.createVehicle();
        car.go();

        Weapon w = factory.createWeapn();
        w.shoot();

        Food bread = factory.createFood();
        bread.printName();
    }
}
