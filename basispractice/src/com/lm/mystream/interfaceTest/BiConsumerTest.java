package com.lm.mystream.interfaceTest;

import org.junit.Test;

import java.util.function.BiConsumer;

/**
 * BiConsumer接口 accept方法  andThen默认方法
 * <p>
 * accept接收两个参数，处理数据，无返回
 * andThen依次执行各对象accept方法
 *
 * @author luoming
 */
public class BiConsumerTest {

    @Test
    public void testBiConsumer() {
        BiConsumer<Integer, Integer> biConsumer = (x, y) -> System.out.println(x + y);
        biConsumer.accept(1, 2);

        BiConsumer<Integer, Integer> consumer = (x, y) -> System.out.println(x * x + y);

        biConsumer.andThen(consumer).accept(2, 1);
    }
}
