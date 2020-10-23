package com.lm.classloader;

public class Singleton {
    //静态变量
    public static int num = 0;

    //静态初始化块
    static {
        System.out.println(num + ":静态块初始化");
    }

    //实例初始化块
    {
        System.out.println(num + ":实例块初始化2");
    }

    //构造方法
    public Singleton() {
        System.out.println(num + ":构造函数初始化");
        num++;
    }


    //实例初始化块
    {
        System.out.println(num + ":实例块初始化1");
    }


    //静态方法
    public static void getInstance() {
        System.out.println(num + ":静态方法初始化");
    }

    public static void main(String[] args) {
        new Singleton();
        new Singleton();
    }
}
