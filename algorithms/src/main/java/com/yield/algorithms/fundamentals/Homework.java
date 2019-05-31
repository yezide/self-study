package com.yield.algorithms.fundamentals;

/**
 * Created by Ye on 2018/1/18.
 */
public class Homework {

    private static int depth = 0;
    /**
     * 1.1.22
     * 二分查找
     * @param key
     * @param a
     * @return
     */
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }
    public static int rank(int key, int[] a, int lo, int hi) {
        for(int i=0; i<depth; i++)
            System.out.print("\t");
        System.out.println("lo:" + lo + " hi:" + hi);
        if(lo > hi) return -1;
        // 计算中间值
        int mid = lo + (hi - lo)/2;
        if(key > a[mid]) {depth++; return rank(key, a, mid + 1, hi);}
        if(key < a[mid]) {depth++; return rank(key, a, lo, mid - 1);}
        return mid;
    }

    /**
     * 1.1.24
     * 欧几里得
     * @param p
     * @param q
     * @return
     */
    public static int gcd(int p, int q) {
        System.out.println("p:" + p + " q:" + q);
        if(q == 0) return p;
        return gcd(q, p % q);
    }

    public static void main(String[] args) {
//        System.out.println(gcd(1111111, 1234567));
        int[] data = {1,2,4,5,7,8,9,10,20,28,39,40};
        System.out.println(rank(10,data));
    }

}
