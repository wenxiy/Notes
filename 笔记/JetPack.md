## JetPack

什么是Jetpack？在Google开发者大会中提出的一套辅助Android开发的组件实用工具。以下的内容主要来自官方文档，利用Kotlin来进行开发学习。加入一些自己的间接，以及一些模板代码，下次继续使用。

### 分类

#### 基础组件

#### 架构组件

#### 行为

#### UI

#### 架构组件

* Navigition(导航组件)：在以前我们对于Activity之间的传输数据都是利用Intent来进行通信，但其实利用Fragment的时候也是可以利用Intent来进行通信。【主要学习Navigition官方文档】

  而对于Jetpack的这个组件Navigition来说就是舍去了在Fragment的时候我们利用的Intent来进行通信，这里只要我是切换到fragment的时候就可以利用此器件或者叫组件，可视化的来展示切换流程图。也就是不仅仅能支持来传输一些数据到fragment，也可以实现应用栏和抽屉式导航栏等更为复杂的模式

  导航组件由以下三个部分组成：

  * 导航图：获取导航XML信息的所有资源
  * Navhost：导航图中的空白容器，显示Fragment目标
  * Navcontroller：在Navhost中管理导航对象，安排目标交换等。