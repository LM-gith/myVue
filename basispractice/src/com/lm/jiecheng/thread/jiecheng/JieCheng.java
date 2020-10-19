package com.lm.jiecheng.thread.jiecheng;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JieCheng {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long bigTime = System.currentTimeMillis();
        int sum = 0;
        long m = 0;
        BigInteger[] bigIntegers = doBigFactorial();
        BigInteger product = new BigInteger("1");
        for (int i = 0; i < 5; i++) {
            product = product.multiply(bigIntegers[i]);
        }
        char[] chs = product.toString().toCharArray();
        for (char ch : chs) {
            sum += Integer.parseInt(Character.toString(ch));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("阶乘位数：" + chs.length);
        System.out.println("阶乘结果位数和: " + sum);
        System.out.println("程序运行时间: " + (endTime - bigTime) + "ms");
    }
    
    private static BigInteger[] doBigFactorial() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        BigInteger[] bigIntegers = new BigInteger[5];

        //在线程池中提交Callable时会返回Future对象
        Future<BigInteger> result0 = service.submit(new Factorial(1, 10000));
        Future<BigInteger> result1 = service.submit(new Factorial(10001, 20000));
        Future<BigInteger> result2 = service.submit(new Factorial(20001, 30000));
        Future<BigInteger> result3 = service.submit(new Factorial(30001, 40000));
        Future<BigInteger> result4 = service.submit(new Factorial(40001, 50000));

        bigIntegers[0] = result0.get();
        bigIntegers[1] = result1.get();
        bigIntegers[2] = result2.get();
        bigIntegers[3] = result3.get();
        bigIntegers[4] = result4.get();
       /* Factorial c = new Factorial(val1, val2);
        //在线程池中提交Callable时会返回Future对象
        FutureTask<Object> result = (FutureTask<Object>) service.submit(c);*/

        return bigIntegers;
    }
}
