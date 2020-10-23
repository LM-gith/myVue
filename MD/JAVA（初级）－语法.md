# JAVA（初级）－语法

### 标识符

1. 凡是可以自己命名的都可以称为标识符

2. 要求

   - 由字母、数字、_(下划线)、$组成，不能以数字开头，不能与JAVA关键字相同

   - 简单、有意义

   - $不应在代码中出现

   - 驼峰命名

     > 类、接口：每个单词首字母大写，其余小写(大驼峰)````````
     >
     > 方法：第二个单词起的首字母大写，其余小写(小驼峰)
     >
     > 常量名：基本数据类型的常量名使用全部大写字母，字与字之间用下划线分隔

3.  关键字

   | 关键字       | 含义                                                         |
   | ------------ | ------------------------------------------------------------ |
   | class        | 声明一个类                                                   |
   | interface    | 接口                                                         |
   | abstract     | 表明类或者成员方法具有抽象属性                               |
   |              |                                                              |
   | implements   | 表明一个类实现了给定的接口类                                 |
   | extends      | 表明一个类型是另一个类型的子类型，常见的类型有类和接口       |
   |              |                                                              |
   | private      | 私有权限，修饰的属性和方法仅供本类引用                       |
   | protected    | 保护权限，保护子类，当前包内和继承的子类中可以引用           |
   | default      | 默认模式，不写任何访问修饰权限，本包内可以使用               |
   | public       | 公用模式，可跨包使用，凡是环境下的类和方法都可以使用，需导入包 |
   |              |                                                              |
   | new          | 用来创建新的实例对象                                         |
   | this         | 指向当前实例对象的引用                                       |
   | super        | 表明当前对象的父类型的引用或者父类型的构造方法               |
   | instanceof   | 用来测试一个对象是否是指定类型的实例对象                     |
   |              |                                                              |
   | final        | 修饰的类不能有子类，或者成员方法不能被覆盖，或者成员域的值不能被改变，用来定义常量 |
   | static       | 表示具有静态属性                                             |
   | synchronized | 线程同步，修饰一段代码表示多个线程都能同步执行               |
   | volatile     | 意识，表明两个或者多个变量必须同步地发生变化                 |
   | native       | 本地用来声明一个方法是由计算机相关语言实现的(如C/C++语言等)  |
   |              |                                                              |
   | try          | 尝试一个可能抛出异常的程序块                                 |
   | catch        | 用在异常处理中，用来捕捉异常                                 |
   | finally      | 用于异常处理情况，用来声明一个基本肯定会被执行到的语句块（有没有异常都执行） |
   | throw        | 通常用在方法体中，抛出一个异常对象，程序在执行到throw语句时停止，不执行后面的语句 |
   | throws       | 方法引发异常，本身不对异常进行处理，将异常抛给调用者使程序可以继续执行下去 |
   |              |                                                              |
   | import       | 导入这个类所存在的包                                         |
   | package      | 定义包的关键字，将有关类放在一个包中                         |
   |              |                                                              |
   | assert       | 断言，用来进行程序调试                                       |

   

### 类

### 接口

### 继承

### 重写

### 重载

### 装箱、拆箱

- 装箱：自动将基本数据类型转为包装器类型
- 拆箱：自动将包装器类型转为基本数据类型
- 装箱过程是通过调用包装器的valueOf方法实现的，而拆箱过程是通过调用包装器的 xxxValue方法实现的(xxx代表对应的基本数据类型)
- 对于包装器类型，equals方法并不会进行类型转换

| 基本数据类型    | 包装器类型 |
| --------------- | ---------- |
| int（4字节）    | Integer    |
| byte（1字节）   | Byte       |
| short（2字节）  | Short      |
| long（8字节）   | Long       |
| float（4字节）  | Float      |
| double（8字节） | Double     |
| char（2字节）   | Character  |
| boolean（未定） | Boolean    |

### 枚举

### 流程控制

### 异常

### 循环

### 字符串

### IO

### 泛型
> 将明确类型的工作推迟到创建对象或调用方法的时候才去明确的特殊的类型 

- 把类型当作是参数传递
- <数据类型>只能是引用类型
- 类上声明的泛型只对非静态成员有效(静态成员的加载早于其他成员)

### optional
> 用于避免大量null的判断

例：
```java
    //每一步都判断对象是否为null
    if(address != null){
       if(address.getCountry() != null){
           if(address.getCountry().getIsocode() != null){
               String isocode = address.getCountry().getIsocode().toUpperCase();
           }
       }
    }
    //使用optional简化后
    Optional.ofNullable(address)
       .map(Address::getCountry)
       .map(Country::getIsocode)
       .map(String::toUpperCase);
```
1.empty()  创建一个value值为null的Optional对象
```java
    Optional<Student> emptyOpt = Optional.empty();
    //optional内部，empty方法调用下面构造方法创建对象
    private Optional() {
        this.value = null;
    }
```
2.get()  获取optional的value值，若value为null，抛出异常
```java
    emptyOpt.get();
    //optional内部，get方法实现
    if (value == null) {
        throw new NoSuchElementException("No value present");
    }
    return value;
```
3.of()、ofNullable()  创建一个value值为传入对象的optional对象，若传入为null，of（）会抛出NullPointerException异常，ofNullable不会抛出任何异常
```java
    //optional内部，of直接调用下面构造方法创建对象
    private Optional(T value) {
        //传入value为null，requireNonNull会抛出NullPointerException异常
        this.value = Objects.requireNonNull(value);
    }

    //optional内部，ofNullable会先判断传入value的值，调用不同方法创建optional对象
    public static <T> Optional<T> ofNullable(T value) {
        return value == null ? empty() : of(value);
    }
```
4.orElse()、orElseGet()、orElseThrow() 当value不为null时，返回value；为null时，orElse、orElseGet为value设置一个默认值，orElseThrow可以抛出异常
```java
    //orElse接收一个对象，orElseGet、orElseThrow接收Supplier接口
    Optional.ofNullable(student).orElse(new Student());
    Optional.ofNullable(student).orElseGet(() -> new Student());
    Student result = Optional.ofNullable(stu).orElseThrow(() -> new IllegalAccessError());
```
5.map()，接收Function接口，处理value。 先通过function处理value，再用optional包装对象之后返回
```java
     public<U> Optional<U> map(Function<? super T, ? extends U> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent())
            return empty();
        else {
            return Optional.ofNullable(mapper.apply(value));
        }
    }
    Optional<String> iscode = Optional.ofNullable(address)
                        .map(address1 -> address1.getCountry())
                        .map(country -> country.getIsocode())
                        .map(is -> is.toUpperCase());
```
6.flatMap(),接收Function接口，处理value。 function直接处理成optional包装的对象
```java
     public<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent())
            return empty();
        else {
            return Objects.requireNonNull(mapper.apply(value));
        }
    }

    Optional<String> iscode = Optional.ofNullable(address)
                            .map(address1 -> Optional.ofNullable(address1.getCountry()))
                            .map(country -> Optional.ofNullable(country.getIsocode()))
                            .map(is -> Optional.ofNullable(is.toUpperCase()));
```
7.filter() 过滤掉不满足条件的value
```java
   Optional<Student> student1 = Optional.ofNullable(student)
                   .filter(s -> s.getName().equals("l")); 
```
### Stream

### 1函数式编程理解

### lamda表达式
### 类加载
   - 初始化概念：执行类或接口的初始化方法<clinit>,该方法由虚拟机自己生成，在初始化阶段被JVM执行
   - 初始化规则：static变量初始化代码和static代码块中的代码，在类初始化是按代码书写顺序被执行，类初始化前，其直接超类已被初始化，直接超类的直接超类也一样