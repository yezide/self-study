package com.yield.designpattern.factorypattern;

/**
 * Created by yezid on 2018/5/3.
 */
public class AK47Factory extends WeaponFactory{


    @Override
    public Weapon create() {
        return new AK47();
    }
}
