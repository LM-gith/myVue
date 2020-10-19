package com.lm.finalTest;

public class MyFinalTest {
    public static void main(String[] args) {
        final int a = 10;
        finalTest(a);
    }


    public static void finalTest(int a) {
        //获取三个整数中的最大值
        int b = 20;
        int c = 30;
        //先比较任意两个数的值，找出这两个数中的最大值
        int temp = (a > b) ? a : b;
        //用前两个数的最大值与第三个数比较，获取最大值
        int max = (temp > c) ? temp : c;
        System.out.println("max = " + max);
    }
}
