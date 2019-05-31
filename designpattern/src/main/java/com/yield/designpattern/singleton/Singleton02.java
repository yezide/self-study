package com.yield.designpattern.singleton;

/**
 * @author yzd
 * @des 内部类懒加载
 * 优点:因为是内部类的静态变量，用到时候才会被加载，并且jvm保证了线程安全。
 * 缺点:无法防止反序列化创建新对象
 * @date 2019/5/17
 */
public class Singleton02 {

    private Singleton02(){}

    private static class Singleton02Holder {
        private static Singleton02 INSTANCE = new Singleton02();
    }

    public static Singleton02 getInstance() {
        return Singleton02Holder.INSTANCE;
    }

    public static boolean deserializationCheck() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Singleton02 instance = getInstance();
        Singleton02 singleton01 = (Singleton02) Class.forName(instance.getClass().getName()).newInstance();
        System.out.println(instance + "---" + singleton01);
        return instance == singleton01;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        System.out.println(deserializationCheck());
        for(int i=0;i<100;i++) {
            new Thread(()->
                System.out.println(getInstance().hashCode())
            ).start();
        }
    }

}
