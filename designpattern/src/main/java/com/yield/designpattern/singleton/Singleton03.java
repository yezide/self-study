package com.yield.designpattern.singleton;

/**
 * @author yzd
 * @des 枚举单列
 * 优点:目前代码层面最完美的单列，并且防止了前面反序列化的问题。
 * @date 2019/5/17
 */
public enum Singleton03 {

    INSTANCE;

    public static Singleton03 getInstance() {
        return INSTANCE;
    }

    public static boolean deserializationCheck() {
        try {
            Singleton03 instance = getInstance();
            Singleton03 singleton01 = (Singleton03) Class.forName(instance.getClass().getName()).newInstance();
            return instance == singleton01;
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("序列化失败,枚举类防止反序列化.");
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(deserializationCheck());
        for (int i = 0; i < 100; i++) {
            new Thread(() ->
                    System.out.println(getInstance().hashCode())
            ).start();
        }
    }

}
