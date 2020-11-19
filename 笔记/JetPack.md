## JetPack

什么是Jetpack？在Google开发者大会中提出的一套辅助Android开发的组件实用工具，具体一点，就是帮助我们去更好的实现MVVM。以下的内容主要来自官方文档，利用Kotlin来进行开发学习。加入一些自己的间接，以及一些模板代码，下次继续使用。

### 基础组件与框架

#### MVVM：



#### Navigition(导航组件)：

在以前我们对于Activity之间的传输数据都是利用Intent来进行通信，但其实利用Fragment的时候也是可以利用Intent来进行通信。【主要学习Navigition官方文档】

而对于Jetpack的这个组件Navigition来说就是舍去了在Fragment的时候我们利用的Intent来进行通信，这里只要我是切换到fragment的时候就可以利用此器件或者叫组件，可视化的来展示切换流程图。也就是不仅仅能支持来传输一些数据到fragment，也可以实现应用栏和抽屉式导航栏等更为复杂的模式

**也就是来切换Fragment而且能指定切换时候的动画**

导航组件由以下三个部分组成：

* 导航图：获取导航XML信息的所有资源
* Navhost：导航图中的空白容器，显示Fragment目标
* Navcontroller：在Navhost中管理导航对象，安排目标交换等。

Demo分析：

1. 首先建立导航图
2. 向Activity添加NavHost
3. 向导航图添加目的地

预备工作：添加依赖

```xml
 	//添加Kotlin中Jetpack的Navigition框架
    def nav_version = "2.3.1"
    implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
    implementation "androidx.navigation:navigation-ui-ktx:$nav_version"
    androidTestImplementation "androidx.navigation:navigation-testing:$nav_version"
```

1. 建立导航图

在res文件夹下点击New Android resource File，选择type为Navigition 

name为nav_graph.

在

2. 