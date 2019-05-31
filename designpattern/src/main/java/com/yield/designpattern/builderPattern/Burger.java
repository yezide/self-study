package com.yield.designpattern.builderPattern;

/**
 * 汉堡包
 * 实现和(抽象、接口)分开
 * Created by yezid on 2018/5/3.
 */
public abstract class Burger implements Item{

    // 所有汉堡包都是用 包装纸 包装。可以实现的在当前实现，
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    // 无法实现的让子类自己实现
    @Override
    public abstract String name();
}
