package com.yield.designpattern.builderPattern;

/**
 * Created by yezid on 2018/5/3.
 */
public abstract class ColdDrink implements Item{
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract String name();

}
