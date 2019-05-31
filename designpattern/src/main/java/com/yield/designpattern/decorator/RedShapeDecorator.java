package com.yield.designpattern.decorator;

/**
 * Created by yezid on 2018/5/7.
 */
public class RedShapeDecorator extends DecoratorShape {

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        this.shape.draw();
        setFrame(this.shape);
    }

    public void setFrame(Shape shape) {
        System.out.println("红色边框");
    }

}
