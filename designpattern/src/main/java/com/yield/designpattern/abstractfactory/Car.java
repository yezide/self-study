package com.yield.designpattern.abstractfactory;

/**
 * Created by yezid on 2018/5/3.
 */
public class Car extends Vehicle {
    @Override
    public void move() {
        System.out.println("冒的尾气飞奔而来..,");
    }
}
