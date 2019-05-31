package com.yield.designpattern.builderPattern;

/**
 * Created by yezid on 2018/5/3.
 */
public class Bottle implements Packing {
    @Override
    public String getPack() {
        return "bottle";
    }
}
