package com.yield.designpattern.observer;

/**
 * Created by yezid on 2018/5/15.
 */
public class Test {

    public static void main(String[] args) {
        // 初始化订阅(被观察者)对象
        Subject subject = new Subject();

        // 初始化观察者对象,并 订阅
        new BinaryObserver(subject);
        new HexObserver(subject);
        // 订阅(被观察者)更新状态，同时会触发所有 订阅 的观察者
        subject.setStatus(80);
    }
}
