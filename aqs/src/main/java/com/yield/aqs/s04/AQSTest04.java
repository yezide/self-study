package com.yield.aqs.s04;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

/**
 * @author yzd
 * @des 加锁
 * @date 2019/6/12
 */
public class AQSTest04 {

    public static int count = 0;

    public static Lock lock = new MyLock();

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(100);

        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    lock.lock();
                    for (int j = 0; j < 100; j++) count++;
                } finally {
                    lock.unlock();
                }
                latch.countDown();
            });
        }

        for (Thread t : threads) t.start();
        latch.await();
        System.out.println(count);
    }

}
