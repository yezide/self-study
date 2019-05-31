package com.yield.designpattern.abstractfactory;

/**
 * Created by yezid on 2018/5/3.
 */
public class DefaultFactory extends AbstractFactory {

    @Override
    public Weapon createWeapon() {
        return new AK47();
    }
    @Override
    public Food createFood() {
        return new Apple();
    }
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

}
