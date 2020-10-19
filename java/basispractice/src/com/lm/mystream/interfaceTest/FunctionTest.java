package com.lm.mystream.interfaceTest;

import org.junit.Test;

import java.util.function.Function;

/**
 * Function接口 apply compose andThen  两个泛型参数 T、R
 * apply T -> R
 * compose 接收一个Function参数A，先执行A.apply，再执行调用者.apply
 * andThen 接收一个Function参数B，先执行调用者.apply，再执行A.apply
 *
 * @author luoming
 */
public class FunctionTest {

    @Test
    public void test() {
        Function<Integer, Integer> test = i -> i + 1;
        System.out.println(test.apply(5));

        Function<Integer, Integer> test1 = i -> i + 1;
        Function<Integer, Integer> test2 = i -> i * i;
        System.out.println(calculate(test1, 5));
        System.out.println(calculate(test2, 5));
        System.out.println();

        System.out.println("F1:" + test1.apply(test2.apply(5)));
        System.out.println("F1:" + test1.compose(test2).apply(5));
        System.out.println("F2:" + test2.apply(test1.apply(5)));
        System.out.println("F2:" + test1.andThen(test2).apply(5));
    }

    public static Integer calculate(Function<Integer, Integer> test, Integer number) {
        return test.apply(number);
    }
}
