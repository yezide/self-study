package com.yield.classloader;

/**
 * @author yzd
 * @des 类加载器
 * 三种类加载器
 *  BootStrap   大部分由C来实现,负责加载rt.jar中的JDK类
 *      Extension   java.lang.ClassLoader来实现，对应类：sun.misc.Launcher$ExtClassLoader,父类加载器无法加载的类,再交给此类去JAVA_HOME/jre/lib/ext下加载对应类
 *          Application     java.lang.ClassLoader来实现，对应类：sun.misc.Launcher$AppClassLoader,负责从classpass下加载对应的类
 *
 * 类加载器的三个机制
 * 1.委托
 *  手写一个Hello.java,Hello.class的请求会由Application委托给父类Extension,Extension再委托给父类BootStrap。BootStrap加载器发现rt.jar中没有这个类,
 *  所以这个请求回到Extension,Extension如果在jre/lib/ext下的所有jar包中能找到这个类那么他会被加载,一旦被加载,Application加载器就不会再加载这个类。如果Extension未找到,
 *  请求就回到Application这个加载器，Application再去classpath下去找这个类。
 *
 * 2.可见性
 *  类加载醒的可见性机制是子类可看到父类加载的类，反之则不行
 *
 * 3.单一性
 *  由前两条机制可见,父加载器加载过的类不能被子加载器加载第二次。
 *
 * @date 2019/5/16
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        try {
            System.out.println(ClassLoaderTest.class.getClassLoader());
            Class.forName("com.yield.classloader.ClassLoaderTest", true, ClassLoaderTest.class.getClassLoader().getParent());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassLoader被Application类加载器加载过，类加载醒的可见性机制是子类可看到父类加载的类，反之则不行，所以会报classNotFound" + e.getMessage());
        }
    }

}
