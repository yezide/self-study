package com.yield.designpattern.bridge;

/**
 * Created by yezid on 2018/5/7.
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(Circle c) {
        System.out.println(c.x + " " + c.y + " " + c.radius + "红色的圆...");
    }
}
