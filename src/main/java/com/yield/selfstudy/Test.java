package com.yield.selfstudy;

/**
 * @author yzd
 * @des
 * @date 2019/5/30
 */
public class Test {

    /**
     *  0 bipush 8  byte类型常量值8*推送至栈顶*
     *  2 istore_1  把栈顶赋值到常量池编号为1的常量  (此时执行完了int a = 8 栈里就一个值 8)
     *  3 iload_1   把局部表量表下标为1的常量进站(栈里现在有两个值 都是8)
     *  4 iinc 1 by 1   把局部表量表下标为1的常量加1(此时栈顶还是8，加1是指对局部标量表数据做操作)
     *  7 istore_1  把栈顶赋值到常量池编号为1的常量(继续把栈顶的8赋值发给局部表量表下标为1的常量 a继续赋值一次8)
     *  8 getstatic #2 <java/lang/System.out>
     * 11 iload_1
     * 12 invokevirtual #3 <java/io/PrintStream.println>
     * 15 return
     * @param args
     */
    public static void main(String[] args) {
        int a = 8;
        a = a++;
        System.out.println(a);
    }

}
