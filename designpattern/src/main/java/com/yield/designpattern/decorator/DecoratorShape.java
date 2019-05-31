package com.yield.designpattern.decorator;

/**
 * Created by yezid on 2018/5/7.
 */
public abstract class DecoratorShape implements Shape {
    Shape shape;

    public DecoratorShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public abstract void draw();


}
