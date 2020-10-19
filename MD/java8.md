Supplier(生产者) :他的泛型一定和方法的返回值类型是一种类型
如果需要获得一个数据,并且不需要传入参数,可以使用Supplier接口.

Consumer(消费者):如果想要处理一个数据,但是不需要返回值,可以使用Consumer接口

predicate(判断):如果想要判断一个数据,并且需要一个布尔类型的返回值,可以使用predicate接口.

Function(函数):如果想要进行属性之间的转换,如String->Integer,则需要使用Function接口,
Function的泛型一般有两种类型,前面的类型表示传入的参数类型,后面的类型表示返回值类型.