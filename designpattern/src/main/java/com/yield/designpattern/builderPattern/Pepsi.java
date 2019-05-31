package com.yield.designpattern.builderPattern;

/**
 * Created by yezid on 2018/5/3.
 */
public class Pepsi extends ColdDrink {
    @Override
    public float price() {
        return (float) 2.5;
    }

    @Override
    public String name() {
        return "pepsi";
    }
}
