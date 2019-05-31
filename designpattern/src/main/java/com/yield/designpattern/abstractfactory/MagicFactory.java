package com.yield.designpattern.abstractfactory;

/**
 * Created by yezid on 2018/5/3.
 */
public class MagicFactory extends AbstractFactory {
    @Override
    public Weapon createWeapon() {
        return new MagicWand();
    }

    @Override
    public Food createFood() {
        return new Mushrooms();
    }

    @Override
    public Vehicle createVehicle() {
        return new Broom();
    }
}
