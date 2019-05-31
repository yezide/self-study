package com.yield.algorithms.fundamentals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 基础
 * Created by Ye on 2018/1/16.
 */
public class GCD {
    /**
     * 欧几里得算法
     * 最大公约数
     *
     * @param p
     * @param q
     * @return
     */
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    /**
     * 颠倒数组内元素
     */
    public static void m() {
        int[] a = {1, 2, 3, 4, 5};
        int length = a.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = a[i];
            a[i] = a[length - 1 - i];
            a[length - 1 - i] = temp;
        }
        for (int i : a)
            System.out.println(i);
    }

    /**
     * 矩阵相乘（不懂啥意思）
     */
    public static void m2() {
        int[][] a = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
        int[][] b = {{6, 7, 8, 9, 10}, {1, 2, 3, 4, 5}};

        int[][] c = new int[5][5];

        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //计算行i和列j的点乘
                for (int k = 0; k < N; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(c[i][j] + " ");
                if (j == N - 1) System.out.println();
            }
        }
    }

    /**
     * 判断一个数是不是 素数
     *
     * @param number
     */
    public static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    /**
     * 计算平方根(牛顿迭代算法)
     *
     * @param c
     * @return
     */
    public static double sqrt(double c) {
        if (c < 0) return Double.NaN;
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c / t) > err * t)
            t = (c / t + t) / 2.0;
        return t;
    }

    /**
     * 计算调和级数
     *
     * @param n
     * @return
     */
    public static double H(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++)
            sum += 1.0 / i;
        return sum;
    }

    /**
     * 二分查找的递归实现
     *
     * @param key 需要查找的数据
     * @param a   数据
     * @return
     */
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int lo, int hi) {
        // 如果key存在于a[]中，他的索引不会小于lo且不会大于hi
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else return mid;
    }

    /**
     * 求一个正整数的二进制码
     *
     * @param N
     */
    public static String toBinaryString(int N) {
//        return Integer.toBinaryString(N);
        String s = "";
        for (int n = N; n > 0; n /= 2)
            s = (n % 2) + s;

        Stack<Integer> stack = new Stack<Integer>();
        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (Integer i : stack) {
            System.out.print(i);
        }
        System.out.println();
        return s;
    }

    /**
     * dijkstra的双栈算术表达式求值算法
     * 约定:所有 数字 和 运算符号 中间以空格分开
     *
     * @param str
     */
    public static void calculator(String str) {
        // 运算符
        Stack<String> ops = new Stack<String>();
        // 数值
        Stack<Double> vals = new Stack<Double>();
        String[] arr = str.split(" ");
        for (String s : arr) {
            if (s.trim().equals("(")) ;
            else if (s.trim().equals("+")) ops.push(s);
            else if (s.trim().equals("-")) ops.push(s);
            else if (s.trim().equals("*")) ops.push(s);
            else if (s.trim().equals("/")) ops.push(s);
            else if (s.trim().equals(")")) {
                String op = ops.pop();
                Double val = vals.pop();
                if (op.trim().equals("+")) val = vals.pop() + val;
                else if (op.trim().equals("-")) val = vals.pop() - val;
                else if (op.trim().equals("*")) val = vals.pop() * val;
                else if (op.trim().equals("/")) val = vals.pop() / val;
                vals.push(val);
            } else vals.push(Double.parseDouble(s));
        }
        System.out.println("result:" + vals.pop());
    }

    /**
     * 1.3.4练习题
     * parentheses
     *
     * @param parentheses
     * @return
     */
    public static boolean parentheses(String parentheses) {
        // 括号栈
        Stack<String> parenthesesStack = new Stack<>();
        // 括号对应关系 map
        Map<String, String> relationParentheses = new HashMap();
        relationParentheses.put(")", "(");
        relationParentheses.put("]", "[");
        relationParentheses.put("}", "{");

        char[] parenthesesArray = parentheses.toCharArray();
        for (char c : parenthesesArray) {
            switch (c) {
                case '(':
                    parenthesesStack.push(String.valueOf(c));
                    break;
                case '[':
                    parenthesesStack.push(String.valueOf(c));
                    break;
                case '{':
                    parenthesesStack.push(String.valueOf(c));
                    break;
                case ')': {
                    String p = parenthesesStack.pop();
                    if (!relationParentheses.get(String.valueOf(c)).equals(p)) return false;
                    break;
                }
                case ']': {
                    String p = parenthesesStack.pop();
                    if (!relationParentheses.get(String.valueOf(c)).equals(p)) return false;
                    break;
                }
                case '}': {
                    String p = parenthesesStack.pop();
                    if (!relationParentheses.get(String.valueOf(c)).equals(p)) return false;
                    break;
                }
                default:
                    System.out.println("包含该无法识别的字符");
                    return false;
            }
        }
        if (parenthesesStack.size() == 0) return true;
        else return false;
    }

    /***
     * @Description:冒泡排序
     * @params: [args]
     * @return: void
     * @author: Yezide
     * @Date: 2019/4/23
     */
    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) swap(array, j, j + 1);
            }
        }
        print(array);
    }

    private static void print(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }

    }

    public static void swap(int[] array, int x, int y) {
        array[x] = array[x] ^ array[y];
        array[y] = array[x] ^ array[y];
        array[x] = array[x] ^ array[y];
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(fundamentals.GCD.gcd(102, 5));
//        m();
//        m2();
//        System.out.println(isPrime(4));
//        System.out.println(sqrt(11));
//        System.out.println(H(11));
//        int[] data = {1,2,4,5,7,8,9,10,20,28,39,40};
//        System.out.println(rank(39,data));
//        System.out.println(toBinaryString(11));

//        BufferedReader strin=new BufferedReader(new InputStreamReader(System.in));
//        String s = strin.readLine();
//        calculator(s);
//        System.out.println(parentheses(s));

        bubbleSort(new int[]{9, 3, 5, 2, 6, 7, 8, 4, 1});

    }

}
