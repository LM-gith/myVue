package com.lm.fatherandchildren.quote;

import org.junit.Test;

/**
 * @author luoming
 */
public class MyTest {
    People lm = new Student();

    @Test
    public void quoteTest() {
        lm.walk();
        lm.look();
    }
}
