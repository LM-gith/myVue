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
    public <T> void show(T t) {
        System.out.println(t);
    }

    public void show() {
        System.out.println(this.obj);
    }
}
