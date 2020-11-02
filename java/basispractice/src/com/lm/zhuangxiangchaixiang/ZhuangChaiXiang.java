package com.lm.zhuangxiangchaixiang;

public class ZhuangChaiXiang {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = Integer.valueOf(321111111);
        Integer f = Integer.valueOf(321111111);
        Long g = 3L;
        Long h = 2L;

        System.out.println(c.equals(d));
        System.out.println(e.equals(f));
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
        System.out.println(g.equals(a + h));
    }
}
