package com.yield.selfstudy.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author yzd
 * @des
 * @date 2019/7/17
 */
public class ThreadPool {

    public static void main(String[] args) {

        /*
         *当线程池中的队列生产满了后的拒绝策略
         * jdk提供了4中实现，默认实现是AbortPolicy
         * 1.AbortPolicy 直接抛出异常
         * 2.DiscardPolicy：直接丢弃要执行的任务
         * 3.CallerRunsPolicy ：线程池满则直接执行当前任务
         * 4.DiscardOldestPolicy ：当任务添加到线程池中被拒绝时，线程池会放弃等待队列中最旧的未处理任务，然后将被拒绝的任务添加到等待队列中。
         * 5.以下是自己的实现。
         */
        RejectedExecutionHandler handler = (r, executor) -> {
            if (!executor.isShutdown()) {
                try {
                    System.out.println("handel coming!");
                    // 往队列尾部放入任务，此方法是阻塞的，可以控制生产的频率。
                    executor.getQueue().put(r);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        };

        // 生产者生产的任务(还未执行)数 > maxinumPoolSize + queue size时，会触发拒绝策略。
        ExecutorService threadPool = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(5), handler);

        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < 522; i++) {

            tasks.add(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " coming!");
                    throw new RuntimeException("test");
                } catch (Exception e) {
                    throw new RuntimeException("test");
                }
//                    return null;
            });
        }

        try {
            long start = System.currentTimeMillis();
            List<Future<Integer>> results = threadPool.invokeAll(tasks, 1, TimeUnit.MINUTES);
            System.out.println("timer:" + (System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        } catch (Exception e) {
            System.out.println("exception");
        }
    }
}
