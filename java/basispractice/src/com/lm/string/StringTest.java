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
}
