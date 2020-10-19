package com.lm.mystream.interfaceTest;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * Supplier接口  仅一个get方法   不传参,返回处理后的数据
 *
 * @author luoming
 */
public class SupplierTest {

    @Test
    public void testSupplier() {
        String hello = "hello";
        String world = "  world";
        Supplier<String> supplier = () -> hello + world;

        System.out.println(supplier.get());
    }
}