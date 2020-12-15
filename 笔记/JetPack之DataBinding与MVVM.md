## JetPack之DataBinding与MVVM

### 什么是DataBinding？

​	DataBinding是Google在开发者大会推出的实现MVVM框架的一种工具，属于JetPack包。而JetPack是一系列的架构，是谷歌官方为开发者所提供能更好的开发的API集合。那么对于开发者来说，什么是MVVM和什么是DataBinding呢？其实，MVVM就是MVP的变形，也就是说，M还是Model，V还是View，VM是ViewModel 在VM中是可以获取View的引用的，为什么？因为ViewModel的产生就是为了去仅仅处理View的数据，达到及时更新，但是对于MVP来说，P是呈现层是获取了View的引用，最后在View中构造的时候就可以调用方法和处理逻辑。对于ViewModel来说，他的逻辑其实是在ViewModel中进行处理的。ViewModel的作用把Model中的数据对象转换成View可以直接使用的形式(String与collection)

### 使用DataBinding与MVVM的好处

* 数据驱动

  UI的展现是依赖于数据的，数据的变化会引起UI的变化，而UI的变化也会使数据层发生改变

* 耦合度低

  ViewModel只负责提供数据和处理数据，不持有View的引用，也不会发生内存泄露，也降低了耦合度

* 方便协作

  一个人负责Ui一个人负责数据

### 一个简单的例子剖析

To begin：

​	github：https://github.com/android/sunflower 这个应用是Google官方的第一个JetPack应用，包括了组件：ROOM、DataBinding、MVVM、WorkRoom 在这里我们先只分析MVVM与Databinding

