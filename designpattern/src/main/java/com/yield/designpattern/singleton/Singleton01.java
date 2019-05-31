package com.yield.designpattern.singleton;

/**
 * @author yzd
 * @des 饿汉模式
 * 优点:简单、实用。
 * 缺点:实例不管是否使用，都会被初始化一遍。
 *      无法防止反序列化创建新对象
 * @date 2019/5/17
 */
public class Singleton01 {

    private static Singleton01 INSTANCE = new Singleton01();

    private Singleton01(){}

    public static Singleton01 getInstance() {
        return INSTANCE;
    }

    public static boolean deserializationCheck() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Singleton01 instance = getInstance();
        Singleton01 singleton01 = (Singleton01) Class.forName(instance.getClass().getName()).newInstance();
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
