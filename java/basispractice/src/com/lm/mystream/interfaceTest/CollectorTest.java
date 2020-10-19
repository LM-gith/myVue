package com.lm.mystream.interfaceTest;

import com.lm.bean.Student;
import com.lm.util.StudentList;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author luoming
 */
public class CollectorTest {

    @Test
    public void collectTest() {
        List<Student> list = StudentList.getStudentList();

        //maxBy获取流中最大值
        Optional<Student> collectMaxBy = list.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(student -> student.getHeight())));
        Optional<Student> collectMaxBy1 = list.stream().max(Comparator.comparingDouble(Student::getHeight));
        System.out.println("collectMaxBy:" + collectMaxBy.get());

        //partitioningBy 分割数据
        Map<Boolean, List<Student>> collectParti = list.stream()
                .collect(Collectors.partitioningBy(student -> student.getHeight() > 170));
        System.out.println("collectParti : " + collectParti);

        //分割数据，使用下游收集器获取分割之后各部分个数 map的key只能为boolean
        Map<Boolean, Long> partiCount = list.stream()
                .collect(Collectors.partitioningBy(student -> student.getHeight() > 170, Collectors.counting()));
        System.out.println("partiCount: " + partiCount);

        //groupingBy 分割数组
        Map<String, List<Student>> collectGroup = list.stream().collect(Collectors.groupingBy(Student::getSex));
        System.out.println("collectGroup : " + collectGroup);

        //格式化字符串
        String strJoin = Stream.of("1", "2", "3", "4").collect(Collectors.joining(",", "[", "]"));
        System.out.println("strJoin: " + strJoin);

    }
}
