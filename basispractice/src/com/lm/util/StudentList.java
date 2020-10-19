package com.lm.util;

import com.lm.bean.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luoming
 */
public class StudentList {

    public static List<Student> getStudentList() {

        Student stuA = new Student(1, "A", "M", 184);
        Student stuB = new Student(2, "B", "G", 163);
        Student stuC = new Student(3, "C", "M", 175);

        List<Student> studentList = new ArrayList<>();
        studentList.add(stuA);
        studentList.add(stuB);
        studentList.add(stuC);
        return studentList;
    }

    public static Student getStudent() {
        return new Student(1, "LM", "M", 163);
    }

}
