package com.yield.designpattern.abstractfactory;

/**
 * Created by yezid on 2018/5/3.
 */
public class test {

    public static void main(String[] args) {
        //
        AbstractFactory factory = new MagicFactory();

        Weapon weapon = factory.createWeapon();
        weapon.shot();

        Food food = factory.createFood();
        food.sayName();

        Vehicle vehicle = factory.createVehicle();
        vehicle.move();
    }




}
