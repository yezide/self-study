package com.yield.designpattern.bridge;

/**
 * Created by yezid on 2018/5/7.
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(Circle c) {
        System.out.println(c.x + " " + c.y + " " + c.radius + "绿色的圆...");
    }
}
