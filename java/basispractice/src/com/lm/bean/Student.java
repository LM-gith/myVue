package com.lm.bean;

import java.util.List;
import java.util.Objects;

/**
 * @author luoming
 */
public class Student extends User {
    int no;

    float height;
    List<String> list;

    public Student(int no, String name, String sex, float height, List<String> list) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.height = height;
        this.list = list;
    }

    public Student(int no, String name, String sex, float height) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.height = height;

    }

    public Student() {

    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Student{" + "no=" + no + ", name='" + name + '\'' + ", sex='" + sex + '\'' + ", height=" + height + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return no == student.no && Float.compare(student.height, height) == 0 && Objects.equals(name, student.name)
                && Objects.equals(sex, student.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, name, sex, height);
    }
}
