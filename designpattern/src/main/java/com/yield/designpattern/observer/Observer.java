package com.yield.designpattern.observer;

/**
 * 观察者
 * Created by yezid on 2018/5/15.
 */
public abstract class Observer {

    // 观察者持有被观察对象
    protected Subject subject;

    // 所有观察者初始化时同时指定 订阅(被观察者)对象
    public Observer(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    // 被观察者状态更新后，同时更新观察者
    public abstract void upadte();

}
