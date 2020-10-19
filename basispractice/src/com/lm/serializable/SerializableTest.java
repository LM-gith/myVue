package com.lm.serializable;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author luoming
 * @date 2019/12/20
 */
public class SerializableTest {

    @SuppressWarnings("resource")
    @Test
    public void simpleDemo() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serializableTest.txt"));

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
