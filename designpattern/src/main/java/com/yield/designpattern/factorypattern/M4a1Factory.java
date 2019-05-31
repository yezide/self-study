package com.yield.designpattern.factorypattern;

/**
 * Created by yezid on 2018/5/3.
 */
public class M4a1Factory extends WeaponFactory {
    @Override
    public Weapon create() {
        return new M4a1();
    }
}
