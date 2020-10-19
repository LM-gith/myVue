package com.lm.generic;

import com.lm.bean.Student;
import com.lm.bean.User;
import com.lm.util.ObjectTool;
import com.lm.util.StudentList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型练习
 */
public class GenericTest {
    Student student = new Student(1, "L", "男", 111);

    @Test
    public void test1() {
        List<Student> students = StudentList.getStudentList();

        //List<Student> 确定了list集合装的是Student类型，所以可以使用增强for对其进行遍历
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    /**
     * 泛型类
     */
    @Test
    public void test2() {
        //创建对象并指定元素类型
        ObjectTool<String> tool = new ObjectTool<>();

        tool.setObj("钟福成");
        String s = tool.getObj();
        System.out.println(s);

        //创建对象并指定元素类型
        ObjectTool<Integer> objectTool = new ObjectTool<>();
        /**
         * 如果我在这个对象里传入的是String类型的,它在编译时期就通过不了了.
         */
        objectTool.setObj(10);
        int i = objectTool.getObj();
        System.out.println(i);

    }

    /**
     * 泛型方法
     */
    @Test
    public void showTest() {
        ObjectTool tool = new ObjectTool();
        tool.show("1111");
        tool.show(1111);

        ObjectTool<?> tool1 = new ObjectTool<>("11111");
        tool1.show();
        tool1 = new ObjectTool<>(1111);
        tool1.show();
    }

    /**
     * PECS
     */
    @Test
    public void pecs() {
        Object obj = new Object();
        List<Student> students = StudentList.getStudentList();
        List<? extends User> list1 = students;
        System.out.println(list1);

        List<? super Student> list2 = new ArrayList<>();
        User user = new User();
        list2.add(student);
    }
}
