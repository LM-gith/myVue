package com.lm.generic;

import com.lm.bean.Student;
import com.lm.bean.User;
import com.lm.util.ObjectTool;
import com.lm.util.StudentList;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型练习
 */
public class GenericTest {
    Student student = new Student(1, "L", "男", 111);

    Object object;

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
    public void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //创建对象并指定元素类型
        ObjectTool<?> tool;
        tool = new ObjectTool<Integer>();

        //tool.setObj("钟福成");
        //String s = tool.getObj();
        //System.out.println(s);

        //创建对象并指定元素类型
        ObjectTool<Integer> objectTool = new ObjectTool<>();
        /**
         * 如果我在这个对象里传入的是String类型的,它在编译时期就通过不了了.
         */
        objectTool.setObj(10);
        objectTool.getClass().getMethod("setObj", Object.class).invoke(objectTool, "1111");
        System.out.println(objectTool.getObj().getClass());

    }

    @Test
    public void test8() {
        setObject(new Student());
        System.out.println(getObject().getClass().getName());
    }

    public void setObject(Object o) {
        this.object = o;
    }

    public Object getObject() {
        return object;
    }

    /**
     * 泛型方法
     */
   /* @Test
    public void showTest() {
        ObjectTool tool = new ObjectTool();
        tool.show("1111");
        tool.show(1111);

        ObjectTool<?> tool1 = new ObjectTool<>("11111");
        tool1.show();
        tool1 = new ObjectTool<>(1111);
        tool1.show();
    }*/
    @Test
    public void showTest() {
        Integer i = ObjectTool.show(111, 222);
        Number number = ObjectTool.show(111, 222.222);
        Number c = ObjectTool.<Number>show(1, 2.2);
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

        List<User> users = new ArrayList<>();
        users.add(new Student());

        List<? super Student> list2 = new ArrayList<>();
        User user = new User();
        list2.add(student);
    }

    /**
     * 类型擦除
     */
    @Test
    public void lxcc() {
        //test3();
        test4();
    }

    @Test
    public void test5() {
        Object[] objects = new String[]{};
        //ArrayList<Object> list1 = new ArrayList<String>();
        ArrayList list3 = new ArrayList<String>();

        List<Integer> integers = new ArrayList<>();

        integers.add(111);
        try {
            integers.getClass().getMethod("add", Object.class).invoke(integers, "2222222");
            // String s = integers.get(1);
            //System.out.println(s.getClass().getName());
            System.out.println(integers);
            System.out.println(integers.getClass().getName());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void test7() {
        User user = new User();
        Student student = (Student) user;
        System.out.println(student);
    }

    public Object test6() {
        return (Object) "22222";
    }

    private void test3() {
        List<Student> students = new ArrayList<>();
        students.add(new Student());
        List<Integer> integers = new ArrayList<>();
        integers.add(111);
        System.out.println(integers.getClass() == students.getClass());
    }

    private void test4() {
        List<Student> students = new ArrayList<>();
        students.add(new Student());
        try {
            students.getClass().getMethod("add", Object.class).invoke(students, 11111);
            Object object = students.get(1);
            System.out.println(students.get(1));
            System.out.println(students);
            System.out.println(students.getClass().getName());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private User test() {
        return new Student();
    }

    @Test
    public void test9() {
        // 编译正常
        List<?>[] lsa2 = new ArrayList<?>[10];
        System.out.println(lsa2.getClass().getName());
    }
}
