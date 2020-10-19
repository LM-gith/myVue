package com.lm.fatherandchildren.quote;

/**
 * @author luoming
 */
public class Student implements People {
    String name = "11111";

    int age = 2222;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void walk() {

    }

    @Override
    public void look() {

    }
}
