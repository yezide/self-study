package com.yield.aqs;

/**
 * @author yzd
 * @des
 * @date 2019/6/12
 */
public class AQSTest01 {

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) count++;
            });
        }

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();  //主线程 等待所有线程执行完毕

        System.out.println(count);
    }

}
