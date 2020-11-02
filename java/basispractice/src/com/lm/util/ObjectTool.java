package com.lm.util;

public class ObjectTool<T> {
    private T obj;

    public ObjectTool() {

    }

    public ObjectTool(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    /**
     * 定义泛型方法..
     *
     * @param t
     * @param <T>
     */
    public static <T> void show(T t) {
        System.out.println(t);
    }

    /**
     * 定义泛型方法..
     *
     * @param t
     * @param e
     * @param <T>
     */
    public static <T> T show(T t, T e) {
        return e;
    }


    public void show() {
        System.out.println(this.obj);
    }
}
