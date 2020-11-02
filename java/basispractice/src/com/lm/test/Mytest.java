package com.lm.test;

import com.lm.bean.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Mytest {

    @Test
    public void test() {
        Student student1 = new Student(111, "LLMM", "男", 111);
        Student student2 = student1;
        student1.setName("sssss");
        System.out.println(student1);
        System.out.println(student2);
    }

    @Test
    public void test3() {
        StringBuilder str = new StringBuilder();
        str(str);
        int leng = str.length();
        System.out.println(str.toString());
    }

    @Test
    public void test4() {
        Integer i = 10;
        //basic(i);
        System.out.println(i);
    }

    @Test
    public void test5() {
        Student student1 = new Student(111, "LLMM", "男", 111);
        List<Student> list = new ArrayList<>();
        list.add(student1);
        student1.setName("zzzzzzzzzz");
        list.add(student1);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }

    @Test
    public void test6() {
        String str = "dghfusehrfasukehfwse";
        int i = 0;
        System.out.println(i);
        System.out.println((i++) + 1);

        System.out.println(i);
    }

    @Test
    public void test7() {
        Student student1 = new Student(111, "LLMM", "男", 111, new ArrayList<String>());
        int no = student1.getNo();
        String name = student1.getName();
        String sex = student1.getSex();
        float height = student1.getHeight();
        List<String> list = student1.getList();
        basic(student1);
        System.out.println("-------------------------");
        System.out.println(no);
        System.out.println(name);
        System.out.println(sex);
        System.out.println(height);
        System.out.println(list);
        System.out.println(student1);

        if (no == 1) {
            System.out.println(222);
        }
    }

    private void basic(Student student1) {
        int no = student1.getNo();

        String name = student1.getName();

        String sex = student1.getSex();

        float height = student1.getHeight();
        List<String> list = student1.getList();
        student1.setName("zzzzzzzzzzz");
        System.out.println(name);
        list.add("string");
        System.out.println(student1);

    }

    private void str(StringBuilder str) {
        String str1 = str.toString();
        int leng = str.length();
        if ("".equals(str.toString())) {
            str.append("11111");
        } else {
            str.append("222");
        }

    }

    @Test
    public void test2() {
        String student1 = "1111211erter";
        String student2 = student1;
        student2.replace("erter", "1");
        System.out.println(student1);
        System.out.println(student2);
    }
}
