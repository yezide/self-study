package com.yield.selfstudy.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author yzd
 * @des cpu层缓存内存数据时，缓存行对齐实验小程序；
 * @date 2021/3/3
 */
public class CacheLinePadding {

    public static long COUNT = 10_000_000L;

    private static class T {
//        private long p1, p2, p3, p4, p5, p6, p7;
//        @Contended
        public volatile long x = 0L;
//        private long p9, p10, p11, p12, p13, p14, p15;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws Exception {
        CountDownLatch cdl = new CountDownLatch(2);

        Thread t1 = new Thread(() -> {
            for (long i = 0; i < COUNT; i++) {
                arr[0].x = i;
            }
            cdl.countDown();
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < COUNT; i++) {
                arr[1].x = i;
            }
            cdl.countDown();
        });

        final long start = System.nanoTime();
        t1.start();
        t2.start();
        cdl.await();
        long end = System.nanoTime();
        System.out.println("耗时:" + (end - start)/1000000);
    }

}
