package com.yield.designpattern.abstractfactory;

/**
 * Created by yezid on 2018/5/3.
 */
public abstract class AbstractFactory {

    public abstract Weapon createWeapon();
    public abstract Food createFood();
    public abstract Vehicle createVehicle();


}
