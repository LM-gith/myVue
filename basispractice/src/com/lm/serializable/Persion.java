package com.lm.serializable;

/**
 * @author luoming
 * @date 2019/12/20
 */
public class Persion {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persion [name=" + name + ", age=" + age + "]";
    }

}
