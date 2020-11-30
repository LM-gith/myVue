package com.lm.mystream.interfaceTest;

import org.junit.Test;

import java.util.function.BinaryOperator;

/**
 * BinaryOperator接口 继承BiFunction接口  两静态方法minBy、maxBy实现apply，比较大小
 *
 * @author luoming
 */
public class BinaryOperatorTest {

    @Test
    public void testBinaryOperatorTest() {
        BinaryOperator<String> binaryOperator = (s, s2) -> null;
    }
}
