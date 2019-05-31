package com.yield.designpattern.bridge;

/**
 * Created by yezid on 2018/5/7.
 */
public class Circle extends Shape {

    protected int x; int y; int radius;

    public Circle(DrawAPI drawAPI, int x, int y, int radius) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(this);
    }
}
