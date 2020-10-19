package com.lm.regularexpression;

import org.junit.Test;

/**
 * @author luoming
 * @date 2020/8/3
 */
public class MyRegularExpressionTest {

    @Test
    public void regularPatternTest() {
        String str = "regularExpressionTest:" + "colour";
        String pattern = "colou\\+r";
        MyRegularExpression.regularPattern(str, pattern);
    }

    @Test
    public void regularMatcher() {
        String str = "regularExpressionTest:" + "colour";
        String pattern = "colou\\+r";
        System.out.println(MyRegularExpression.regularMatcher(str, pattern));
    }
}
