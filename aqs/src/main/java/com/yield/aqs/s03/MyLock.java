package com.yield.aqs.s03;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author yzd
 * @des
 * @date 2019/6/17
 */
public class MyLock implements Lock {

    volatile int i = 0;

    @Override
    public void lock() {
        synchronized (this) {
            while (i != 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = 1;
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        synchronized (this) {
            i = 0;
            this.notifyAll();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
