package com.lm.mystream.interfaceTest;

import com.lm.bean.Student;
import com.lm.util.StudentList;
import org.junit.Test;

import java.util.function.Predicate;

/**
 * @author luoming
 */
public class PredicateTest {

    @Test
    public void testPredicate() {
        Student student = StudentList.getStudent();
        Predicate<Student> predicate1 = stu -> stu.getHeight() > 160;
        Predicate<Student> predicate2 = stu -> "M".equals(stu.getSex());
        Predicate<Student> predicate3 = Predicate.isEqual(student);
        if (predicate1.test(student)) {
            System.out.println("身高>160");
        }
        if (predicate1.and(predicate2).test(student)) {
            System.out.println("身高>160 男");
        }

        if (predicate1.or(predicate2).test(student)) {
            System.out.println("身高>160 || 男");
        }

        if (predicate3.test(student)) {
            System.out.println("身高>160 || 男");
        }
    }
}
