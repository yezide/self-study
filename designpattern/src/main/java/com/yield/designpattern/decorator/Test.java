package com.yield.designpattern.decorator;

/**
 * Created by yezid on 2018/5/7.
 */
public class Test {

    public static void main(String[] args) {
        // new一个装饰者，装饰者持有具体的产品(shape)，可在产品操作前/后加上装饰的逻辑
        RedShapeDecorator redFlameCircle = new RedShapeDecorator(new Circle());
        redFlameCircle.draw();

        RedShapeDecorator redFlameRectangle = new RedShapeDecorator(new Rectangle());
        redFlameRectangle.draw();
    }

}
