package com.yield.designpattern.builderPattern;

/**
 * Created by yezid on 2018/5/3.
 */
public class Coke extends ColdDrink {
    @Override
    public float price() {
        return (float) 2.0;
    }

    @Override
    public String name() {
        return "coke";
    }
}
