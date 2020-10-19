package com.lm.classloader;

public class ClassLoadLinkTest {
    {
        System.out.println(1111111);
    }

    public static void main(String[] args) {
        Son son = new Son();
        System.out.println("----end-----");
    }
}

class Son extends Father {
    private int i = 1;
    private long l = 2L;
    static int ssi = 3;

    {
        System.out.println("1son init block");
    }

    static {
        System.out.println("2son static block");
    }

    Son() {
        l = 3L;
        System.out.println("3son constructor");
    }
}

class Father {
    int fi;
    static int fsi = 4;
    static Son son = new Son();

    {
        System.out.println("4father init block");
    }

    static {
        System.out.println("5father static block");
    }

    Father() {
        fi = 1;
        System.out.println("6father constructor");
    }
}
