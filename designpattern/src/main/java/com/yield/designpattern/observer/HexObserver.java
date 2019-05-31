package com.yield.designpattern.observer;

/**
 * Created by yezid on 2018/5/15.
 */
public class HexObserver extends Observer {


    public HexObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void upadte() {
        System.out.println("十六进制结果:" + Integer.toHexString(this.subject.getStatus()));
    }
}
