# 字符串
## 创建字符串
1.字面量
```java
    //编译时 aa、aaa、aaaaa均存入常量池
    String str1 = "aa" + "aaa";
```
2.通过new
```java
    //编译时，堆中、常量池中都存入aaa(两个对象)
     String str2 = new String("aaa");

    //编译时，a、aa存入常量池,aaa未存入常量池
    String str3 = new StringBuilder().append("a").append("aa").toString();
    //常量池存入aaa的引用，并返回；str3 == str3.intern();
    str3.intern();
```
## intern()方法
> 调用C++语言的方法；调用时，若常量池中存在该字符串，则返回该字符串否则将此字符串添加到常量池中，并返回字符串的引用

![Alt](C:\Users\luoming\Pictures\Saved Pictures\MD\String\stringPool.png)

