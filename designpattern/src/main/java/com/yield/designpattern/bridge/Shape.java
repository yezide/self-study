package com.yield.designpattern.bridge;

/**
 * 抽象
 * Created by yezid on 2018/5/7.
 */
public abstract class Shape {

    protected DrawAPI drawAPI;

    public Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();

}
