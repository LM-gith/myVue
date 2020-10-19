package com.lm.jiecheng.thread.jiecheng;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class Factorial implements Callable<BigInteger> {

    private long val1;
    private long val2;
    private BigInteger sum;

    public Factorial(long val1, long val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public void sum() {
        BigInteger temp = BigInteger.valueOf(val1);
        long length = val2 - val1 + 1;
        for (int i = 1; i < length; i++) {
            temp = temp.multiply(BigInteger.valueOf(val1 + i));
        }
        sum = temp;
    }

    @Override
    public BigInteger call() {
        sum();
        return sum;
    }

}
