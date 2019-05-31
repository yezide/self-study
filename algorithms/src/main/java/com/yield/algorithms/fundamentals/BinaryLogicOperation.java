package com.yield.algorithms.fundamentals;

/**
 * @author yzd
 * @des 二进制逻辑运算
 * & -- 与	(遇0则0)
 * | -- 或 (遇1则1)
 * ~ -- 取反
 * ^ -- 异或 (不进位相加)
 * >> -- 右移位 (为负数时，补符号位(1) 其他补零 = 正整数 / 2)
 * << -- 左移位 (无条件补零 = * 2)
 * >>> -- 无符号右移位 (无条件补零)
 * @date 2019/4/23
 */
public class BinaryLogicOperation {

    public static void logicOperation() {
        int i = 9;
        int j = 14;
        System.out.println(i + "转二进制:" + Integer.toBinaryString(i));
        System.out.println(j + "转二进制:" + Integer.toBinaryString(j));

        System.out.println(i + "&" + j + "运算后值:" + (i & j) + " 二进制值" + Integer.toBinaryString(i & j));
        System.out.println(i + "|" + j + "运算后值:" + (i | j) + " 二进制值" + Integer.toBinaryString(i | j));
        System.out.println("~" + i + "运算后值:" + (~i) + " 二进制值 " + Integer.toBinaryString(~i));
        System.out.println("~" + j + "运算后值:" + (~j) + " 二进制值 " + Integer.toBinaryString(~j));
        System.out.println(i + "^" + j + "运算后值:" + (i ^ j) + " 二进制值" + Integer.toBinaryString(i ^ j));
        System.out.println(i + ">>1运算后值:" + (i >> 1) + " 二进制值 " + Integer.toBinaryString(i >> 1));
        System.out.println(j + ">>1运算后值:" + (j >> 1) + " 二进制值 " + Integer.toBinaryString(j >> 1));
        System.out.println(i + "<<1运算后值:" + (i << 1) + " 二进制值 " + Integer.toBinaryString(i << 1));
        System.out.println(j + "<<1运算后值:" + (j << 1) + " 二进制值 " + Integer.toBinaryString(j << 1));
        System.out.println(i + ">>>1运算后值:" + (i >>> 1) + " 二进制值 " + Integer.toBinaryString(i >>> 1));
        System.out.println(j + ">>>1运算后值:" + (j >>> 1) + " 二进制值 " + Integer.toBinaryString(j >>> 1));

        int k = 254;
        System.out.println(k + "转二进制:" + Integer.toBinaryString(k));
        System.out.println(k + ">>1运算后值:" + (k >> 1) + " 二进制值 " + Integer.toBinaryString(k >> 1));
        int l = -2;
        System.out.println(l + "转二进制:" + Integer.toBinaryString(l));
        System.out.println(l + ">>1运算后值:" + (l >> 1) + " 二进制值 " + Integer.toBinaryString(l >> 1));
        System.out.println(l + ">>>1运算后值:" + (l >>> 1) + " 二进制值 " + Integer.toBinaryString(l >>> 1));

    }

    /***
     * @Description:冒泡排序
     * @params: [args]
     * @return: void
     * @author: Yezide
     * @Date: 2019/4/23
     */
    public static int[] bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) swap(array, j, j + 1);
            }
        }
        print(array);
        return array;
    }

    private static void print(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    /**
     * @Description:二叉查找法
     * @params: [number 需要查找的数, a, lo, hi]
     * @return: int
     * @author: Yezide
     * @Date: 2019/4/23
     */
    public static int rank(int number, int[] a, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = hi - (hi - lo >> 1);
        if (number > a[mid]) return rank(number, a, mid, hi);
        if (number < a[mid]) return rank(number, a, lo, mid);
        else return mid;
    }

    /**
     * 两个数转换的最快方法 ^
     *
     * @param array
     * @param x
     * @param y
     */
    public static void swap(int[] array, int x, int y) {
        array[x] = array[x] ^ array[y];
        array[y] = array[x] ^ array[y];
        array[x] = array[x] ^ array[y];
    }

    public static void main(String[] args) {
        logicOperation();
        int[] sorted = bubbleSort(new int[]{9, 3, 5, 2, 6, 7, 8, 4, 1});
        int index = rank(2, sorted, 0, sorted.length - 1);
        System.out.println(index);
    }

}
