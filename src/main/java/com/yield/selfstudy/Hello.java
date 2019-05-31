package com.yield.selfstudy;

/**
 * @author yzd
 * @des
 *
 * 1.字节码怎么进入虚拟机
 *  类加载器加载到虚拟机，其中有7个步骤
 *      加载:
 *          通过io load到jvm,转成为一个与目标类型对应的java.lang.Class对象实例
 *      验证:
 *          格式检查：class文件的'魔数'值(4个字节表示cafe babe)是否满足jvm规范。class文件版本(4个字节，前2个字节小版本号，后两个字节是大版本号，16进制表示)是否兼容当前jvm版本；
 *          语义检查、字节码验证、符号引用验证
 *      准备:
 *          为类中所有静态变量分配内存空间，并设置初始值。(不是实际的变量值，比如static int i=9，此时不是初始化为9)
 *          被final修饰的静态变量才会直接赋予变量值。
 *      解析:
 *          将常量池中的符号引用转为直接引用(即在内存中对应内存地址)
 *      初始化:
 *          所有static变量初始化语句，static代码块都会存放在<clinit>(class impliments init)方法中，此方法只能由JVM在类加载的过程中调用。
 *          JVM执行所有被static关键字修饰过的代码，如果是变量，会把变量值覆盖 准备阶段 的初始值。
 *          JVM负责保证一个类初始化之前，它的父类<clinint>已经被执行。
 *          初始化的过程jvm保证了线程安全
 *      使用
 *      卸载
 * 2.虚拟机如何启动
 * 3.虚拟机如何解析字节码
 * 4.jvm内部java对象模型 oop-class是什么?
 *          1.对象头
 *              1.mark word：标记字(长度和虚拟机位数长度保持一致 32 or 64 bits)
 *                  存储对象本身的运行时数据
 *                      hash码(最大31位),hashcode的实现就是os::random()方法
 *                      gc年龄(4位),这就是survivor区from to 16次之后放入老年代
 *                      偏移锁标识(1位 此状态1 && 锁标识01时，表示可偏向状态。), 只有一个线程，没有其他线程争抢资源的情况下进一步的性能提高。
 *                      锁标识(2位),4钟状态
 *                          00:locked 轻量级锁是竞争资源的线程不多、资源持有者的时间不长时，采用的一种解决方案。
 *                              其内部是为了避免线程之间通信大量好肥性能(用户态和内核态上下文切换),所以直接让竞争线程进入自旋，等待锁释放。自旋过程中抢到锁资源的线程会通过cas把对象头替换到栈顶，让lock record的指针指向对象头。
 *                          01:unlocked
 *                          10:monitor 重量级锁 在轻量级锁的过程中，多个线程同时竞争锁，并且自旋一段时间后，还是无法获取锁，竞争锁的线程会进入内核态，这时轻量级锁就会膨胀为重量级锁。
 *                          11:marked
 *
 *              2.类型指针
 *              3.数组长度(只有数组对象才有)
 *          2.实例数据
 *          3.对齐填充
 * 5.垃圾回收机制怎么实现的
 * 6.什么是线程安全点？JVM执行安全点的两种方式？
 *  线程运行到某些位置，只有所有java线程都进入到safepoint的时候，jvm才能进行GC。主要有以下几个
 *      循环末尾
 *      方法返回前
 *      调用方法的call之后
 *      抛出异常位置
 *  两种安全点执行方式
 *      编译型(JIT)
 *          hotspot在x86中为轮询safepoint会生成一条类似于 "test %eax,0x160100"的指令，gc前，把0x160100设置为不可读，这样所有线程执行到这条指令后都会停顿下来
 *      解释型
 *          jvm设置2个字节的dispatch tables，当有safepoint请求时，解释器会它让去检查dispatch tables是否存在。
 *  JVM对应参数:可以设置JVM参数 -XX:+PrintSafepointStatistics –XX:PrintSafepointStatisticsCount=1 来输出safepoint的统计信息
 * 7.什么是oopmap
 * 8.java的动态链接是什么样的？
 * 9.常量池是什么?
 *  常量池就是一个数组，存放东西的叫entry
 *
 * @date 2019/5/27
 */
public class Hello {

    public static void main(String[] args) {
        System.out.println("Hello");
    }

}
