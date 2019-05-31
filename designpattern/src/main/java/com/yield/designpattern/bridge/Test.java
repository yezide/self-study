package com.yield.designpattern.bridge;

/**
 * Created by yezid on 2018/5/7.
 */
public class Test {

    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedCircle(), 100, 200, 30);
        Shape greenCircle = new Circle(new GreenCircle(), 110, 220, 33);
        redCircle.draw();
        greenCircle.draw();
    }

}
