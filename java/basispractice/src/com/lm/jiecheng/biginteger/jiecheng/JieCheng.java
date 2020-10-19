package com.lm.jiecheng.biginteger.jiecheng;

import java.math.BigInteger;

public class JieCheng {

    public static void main(String[] args) {
        long bigTime = System.currentTimeMillis();
        int sum = 0;
        char[] chs = product().toString().toCharArray();
        for (char ch : chs) {
            sum += Integer.parseInt(String.valueOf(ch));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("和为" + chs.length);
        System.out.println("和为" + sum);
        System.out.println("耗时" + (endTime - bigTime));
    }

    private static BigInteger product() {
        int num = 50000;
        BigInteger product = new BigInteger("1");

        for (int i = 2; i <= num; i++) {
            product = product.multiply(BigInteger.valueOf(i));
        }
        return product;
    }
}
