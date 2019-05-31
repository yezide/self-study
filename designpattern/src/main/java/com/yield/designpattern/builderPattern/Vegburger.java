package com.yield.designpattern.builderPattern;

/**
 * Created by yezid on 2018/5/3.
 */
public class Vegburger extends Burger {
    @Override
    public float price() {
        return (float) 3.5;
    }

    @Override
    public String name() {
        return "vegBurger";
    }
}
