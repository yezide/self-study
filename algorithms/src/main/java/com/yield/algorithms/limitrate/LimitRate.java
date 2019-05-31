package com.yield.algorithms.limitrate;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author yzd
 * @des 限流算法(滑动窗口)
 * @date 2018/9/13
 */
public class LimitRate {

    private AtomicLong counter = new AtomicLong(0);

    LinkedList<Long> ll = new LinkedList<>();

    static int count = 50;

    private void doCheck() throws InterruptedException {
        while (true) {

            ll.addLast(counter.get());
            if (ll.size() > 10) {
                ll.removeFirst();
            }
//            System.out.println("当前容器数量:" + ll.size() + " last:" + ll.peekLast() + " first:" + ll.peekFirst());

            // 比较最后一个和第一个，两者相差1秒
            if (ll != null && ll.size() > 0 && ll.peekLast() - ll.peekFirst() > 10) {
//                System.out.println("第" + counter + "个用户 limit rate");
                for (int j = 0; j < ll.peekLast() - ll.peekFirst(); j++) {
                    ll.removeFirst();
                }
            } else {
                if (counter.get() < count) {
                    System.out.println("第" + counter + "个用户 passing");
                }
            }
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }

    public static void main(String[] args) {
        LimitRate lr = new LimitRate();

        new Thread(() -> {
            try {
                lr.doCheck();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            for (int i = 0; i < count; i++) {
                lr.counter.incrementAndGet();
                TimeUnit.MILLISECONDS.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
