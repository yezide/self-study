package com.yield.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 订阅(被观察者)
 * Created by yezid on 2018/5/15.
 */
public class Subject {

    List<Observer> observers = new ArrayList<Observer>();

    int status;

    public int getStatus() {
        return status;
    }

    // 状态更新，触发观察者操作
    public void setStatus(int status) {
        this.status = status;
        notifiAllObservers();
    }

    // 订阅 后的观察者，放入list
    public void attach(Observer observer) {
        observers.add(observer);
    }

    private void notifiAllObservers() {
        for(Observer observer : observers) observer.upadte();
    }
}
