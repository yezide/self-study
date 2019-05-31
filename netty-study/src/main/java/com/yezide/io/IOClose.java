package com.yezide.io;

import java.io.*;

/**
 * @author yzd
 * @des本类解释IO关闭的正确方式
 *
 *  Throwable.addSuppressed的作用
 *  在JDK1.7 以前，一旦finally块抛出了close函数里的异常，前面try块catch的异常被丢弃了!可以通过addSuppressed把它保存起来。
 *  也可以用Throwable.getSuppressed函数来取出close之前的异常了
 * @date 2019/5/14
 */
public class IOClose {

    private static void test(File file) throws Exception {
        InputStream input = null;
        Throwable throwable = null;
        try {
            input = new FileInputStream(file);
            OutputStream outputStream = new FileOutputStream(file);
            outputStream = null;
            outputStream.close();
        } catch (Throwable e) {
            throwable = e;
            throw e;
        } finally {
            if (input != null) {
                if (throwable != null) {
                    try {
                        input = null;
                        input.close();
                    } catch (Throwable var) {
                        // 保存try块catch丢弃的异常。
                        throwable.addSuppressed(var);
                    }
                } else {
                    System.out.println(input);
                    input.close();
                }

            }
        }
    }

    public static void main(String[] args) {
        try {
            test(new File("D:\\zhuomian\\logs\\myeasylog.log"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
