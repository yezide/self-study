package com.yield.designpattern.decorator;

/**
 * Created by yezid on 2018/5/7.
 */
public class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("圆圈");
    }
}
