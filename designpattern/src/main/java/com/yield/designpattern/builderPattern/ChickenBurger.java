package com.yield.designpattern.builderPattern;

/**
 * Created by yezid on 2018/5/3.
 */
public class ChickenBurger extends Burger {
    @Override
    public float price() {
        return (float) 5.5;
    }

    @Override
    public String name() {
        return "chickenBurger";
    }
}
