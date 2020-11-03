package com.lm.string;

import org.junit.Test;

public class StringTest {

    @Test
    public void test1() {
        String str = "abc";
        changeString(str);
        str.intern();
        System.out.println(str.substring(1, 1));
    }

    private void changeString(String str) {
        str = "fhr";
    }

    @Test
    public void test2() {
        String str1 = "abc";
        String str2 = new String("abc");
        System.out.println(str1 == str2);
        System.out.println(str1 == str2.intern());
    }

    @Test
    public void test3() {
        String s = "a";
        String str1 = "aaa";
        String str2 = new String("aaa");
        String str3 = "a" + "aa";
        String str4 = s + "aa";
        System.out.println("str1==str2?" + (str1 == str2));
        System.out.println("str1==str2.intern()?" + (str1 == str2.intern()));
        System.out.println("str1==str3?" + (str1 == str3));
        System.out.println("str1==str4?" + (str1 == str4));
        System.out.println("str1==str4.intern()?" + (str1 == str4.intern()));
    }

    @Test
    public void test4() {
        String s1 = new StringBuilder().append("String").append("Test").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder().append("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }

    @Test
    public void test5() {
        String str1 = new StringBuffer().append("好好").toString();
        String string = new StringBuffer("ja").append("va").toString();
        System.out.println(str1.intern() == str1);
        System.out.println(string.intern() == string);
    }

    @Test
    public void test6() {
        // String str1 = "aa" + "aaa";
        String str2 = new StringBuilder().append("a").append("a").toString();
        String str3 = new StringBuilder().append("aaa").append("aaa").toString();

        System.out.println(str2 == str2.intern());//F
        System.out.println(str3 == str3.intern());//F


        String str4 = new String("hello");

    }
}
