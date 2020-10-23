package com.lm.optional;

import com.lm.bean.Student;
import com.lm.optional.bean.Address;
import com.lm.optional.bean.Country;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


/**
 * @author luoming
 */
public class OptionalTest {

    Student student = new Student(1, "L", "男", 111);

    @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptionalThenNull() {
        Optional<Student> emptyOpt = Optional.empty();
        emptyOpt.get();
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateOfEmptyOptionalThenNullPointerException() {
        Optional<Student> opt1 = Optional.of(student);
        Optional<Student> opt2 = Optional.ofNullable(student);
    }

    @Test
    public void whenCheckIfPresentThenOk() {
        Optional<Student> opt = Optional.ofNullable(student);
        assertTrue(opt.isPresent());
        opt.ifPresent(student -> assertEquals(student.getHeight(), opt.get().getHeight()));
        assertEquals(student.getHeight(), opt.get().getHeight());
    }

    @Test
    public void orElseFunction() {
        Student stu = new Student(2, "M", "男", 133);
        //student(初始值)、stu(默认值),若student为null,则传递默认值stu
        Student result = Optional.ofNullable(student).orElse(stu);
        assertEquals(student.getHeight(), result.getHeight());
        System.out.println(result);

        student = null;
        //student(初始值)、stu(默认值),若student为null,则传递默认值stu
        result = Optional.ofNullable(student).orElse(stu);
        assertEquals(stu.getHeight(), result.getHeight());
        System.out.println(result);
    }

    @Test
    public void orElseGetFunction() {
        Student stu = null;
        //orElseGet  传入的 Supplier(供应者) 函数式接口
        Student result = Optional.ofNullable(stu).orElseGet(() -> student);
        assertEquals(student.getHeight(), result.getHeight());
    }

    @Test
    public void orElseThrowFunction() {
        Student stu = null;
        //orElseGet  传入的 Supplier(供应者) 函数式接口
        Student result = Optional.ofNullable(stu).orElseThrow(IllegalAccessError::new);
        assertEquals(student.getHeight(), result.getHeight());
    }

    @Test
    public void different() {
        //两个Optional对象都包含非空值，两个方法都会返回对应的非空值。不过，orElse()方法仍然调用createNewUser()。与之相反，orElseGet()方法不调用createNewUser()。
        //orElse入参为泛型T，传方法是会先解析方法，获取方法返回值，此时会执行createNewUser()
        //而orElseGet入参为Supplier接口，student不为NULL时不会执行
        System.out.println("Using orElse");
        Optional.ofNullable(student).orElse(createNewUser());
        System.out.println("Using orElseGet");
        Optional.ofNullable(student).orElseGet(this::createNewUser);
    }

    private Student createNewUser() {
        System.out.println("调用 createNewUser()");
        return new Student();
    }

    @Test
    public void whenMap_thenOk() {
        String name = Optional.ofNullable(student)
                .map(s -> s.getName()).orElse("default@gmail.com");
        Optional<Student> student1 = Optional.ofNullable(student)
                .filter(s -> s.getName().equals("l"));
        assertTrue(student1.isPresent());
        assertEquals(name, student.getName());
    }

    @Test
    public void mapAndflatMap() {
        Address address = new Address();
        address.setCountry(new Country("11111111"));
   Optional.ofNullable(address).flatMap(address1 -> Optional.ofNullable(address1.getCountry()));

        Optional<String> iscode = Optional.ofNullable(address)
                .map(Address::getCountry)
                .map(Country::getIsocode)
                .map(String::toUpperCase);
        System.out.println(iscode);
    }


}
