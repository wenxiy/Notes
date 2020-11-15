#### JAVA中String类的常量池问题

对于一个JAVA程序中来说，常量池中存储这一些必要的常量。

在String类只是创建了一个引用的时候，是放入常量池例如：

```java
String s1 = "student";
```

这个引用指向常量池中的student

但是如果是new

```java
String s1 = new String("student");
```

就是创建了一个实例，并且指向这个实例 而对于我们JAVA中的

s1与s2的字符序列是相同的，但是不是相同的引用，所以==运算时为false（==运算符比较的是引用）

但是如果使用equal是true 因为equal比较的是字符序列。