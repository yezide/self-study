package com.yield.designpattern.factorypattern;

/**
 * Created by yezid on 2018/5/3.
 */
public class test {

    public static void main(String[] args) {
        WeaponFactory factory = new M4a1Factory();
        Weapon weapon = factory.create();
        weapon.shot();
    }

}
