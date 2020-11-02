# optional
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