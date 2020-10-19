package com.lm.mystream;

import com.lm.bean.Student;
import com.lm.util.StudentList;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @author luoming
 */
public class BaseStreamTest {

    public void createStream() {
        List<Student> list = StudentList.getStudentList();
        //of 有限长度
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Stream<String> stringStream = Stream.of("1", "2", "3");

        //generator 无限长度
        Stream<Integer> generateA = Stream.generate(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 1;
            }
        });
        Stream<Integer> generateB = Stream.generate(() -> 1);

        //iterate 无限长度
        Stream<Integer> iterateA = Stream.iterate(1, new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 1;
            }
        });
        Stream<Integer> iterateB = Stream.iterate(1, integer -> integer + 1).limit(10);

        //集合、数组
        Stream<Student> listStream = list.stream();
        Stream arrayStream = Arrays.stream(list.toArray());

    }

    @Test
    public void intermediateFunction() {
        List<Student> list = StudentList.getStudentList();

        //合并两个流
        Stream.concat(list.stream(), list.stream()).forEach(System.out::println);
        System.out.println();

        //去重
        Stream.concat(list.stream(), list.stream()).distinct().forEach(System.out::println);
        System.out.println();

        //过滤
        list.stream().filter(student -> "A".equals(student.getName())).forEach(System.out::println);
        System.out.println();

        //处理元素
        list.stream().peek(student -> student.setName(student.getName().toLowerCase())).forEach(System.out::println);
        list.stream().map(student -> student.getName().toLowerCase()).forEach(System.out::println);
        list.stream().flatMap(student -> Stream.of(student.getName().toLowerCase())).forEach(System.out::println);
        System.out.println();

        //删除前N各元素,  N > length返回空stream
        list.stream().skip(3).forEach(System.out::println);
        System.out.println();

        //排序
        list.stream().sorted().forEach(System.out::println);
    }

    @Test
    public void terminalFunction() {
        List<Student> list = StudentList.getStudentList();

        //个数
        System.out.println("count = " + list.stream().count());
        System.out.println();

        //最值
        System.out.println("maxHeight = " + list.stream()
                .max((student1, student2) -> (int) (student1.getHeight() - student2.getHeight())));
        System.out.println("minHeight = " + list.stream()
                .min((student1, student2) -> (int) (student1.getHeight() - student2.getHeight())));
        System.out.println();
    }

    @Test
    public void shortCircuitingFunction() {
        List<Student> list = StudentList.getStudentList();

        //全部满足 true
        System.out.println("allMatch = " + list.stream().allMatch((student) -> student.getHeight() > 180));
        //都不满足 true
        System.out.println("noneMatch = " + list.stream().noneMatch((student) -> student.getHeight() > 190));
        //任一满足 true
        System.out.println("anyMatch = " + list.stream().anyMatch((student) -> student.getHeight() > 180));
        //findAny findFirst
        System.out.println("findAny = " + list.stream().findAny());
        System.out.println("findFirst = " + list.stream().findFirst());
    }
}
