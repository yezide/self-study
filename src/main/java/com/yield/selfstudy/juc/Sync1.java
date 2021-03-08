package com.yield.selfstudy.juc;

import com.yield.selfstudy.Hello;
import org.openjdk.jol.info.ClassLayout;


/**
 * @author yzd
 * @des 锁信息
 * @date 2021/3/4
 */
public class Sync1 {

    public static void main(String[] args) throws Exception {

        Thread.sleep(5000);

        Hello hello = new Hello();
        ClassLayout classLayout = ClassLayout.parseInstance(hello);
        System.out.println(classLayout.toPrintable());

        synchronized (hello) {
            ClassLayout layout = ClassLayout.parseInstance(hello);
            System.out.println(layout.toPrintable());
        }

    }

}
