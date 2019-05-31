package com.yield.designpattern.observer;

/**
 * Created by yezid on 2018/5/15.
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        super(subject);
    }
    @Override
    public void upadte() {
        System.out.println("二进制结果:" + Integer.toBinaryString(this.subject.getStatus()));
    }
}
