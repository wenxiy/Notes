# Android编程权威指南

* Android studio基础
* Android开发基础
* 

### Android开发基础

为了自己能方便复习，自己写一些笔记性的东西来进行回顾。

期间用两种方法进行开发：kotlin和Java。举一些例子

一个Android应用包括了Activity和布局资源组成。**Activity**用来管理界面和处理应用功能。

布局资源包括了布局和其他资源

**布局**是用户界面对象以及显示在屏幕的位置

组成布局的定义保存在XML(Extensible Markup Language)文件中，XML文件定义了界面等

#### 命名规范

自动产生包名：com.公司名(DNS反转).应用名//导入的包

如果要创建包：

| 类别     | 约定                | 例子          |
| -------- | ------------------- | ------------- |
| Activity | 首字大写词+Activity | QuizActivity  |
| Layout   | activity+_+名称     | activity_quiz |
|          |                     |               |

#### 布局->视图对象

我们在初始Activity中拥有Oncreate时候调用，利用SetContentView传入了布局资源ID参数，随之完成了实例化。

在xml文件的语言中，我们的xmlns:android="http://······"声明的是属性空间

常用组件属性：

* android:layout_width与ndroid:layout_height
  * match_parent:视图与父视图相同
  * wrap_parent:根据内容自动调整

* android:orientation
  * vertial:决定布局下的组件是垂直
  * horizontal:决定布局下的组件是水平
* android:text
  * 直接写出text文本
  * 引用资源文件:android:text=@string/name
* android:id
  * @id/id_name:声明组件id，方便引用

#### 创建Button按钮

一个Button代表的一个可以点击的组件，在Button上可以设置点击后的app反应，当然我们需要在XML布局文件中声明一下

```xml
<Button
        android:id="button_name"
        android:layout_width="wrap_parent"
        android:layout_height="wrap_parent"
        android:text="@string/button_name"/>
```

随后我们需要在MainActivity中处理

需要先引用

```java
private Button button_name;
```

```java
button_name = findViewById(R.id.button_name);
```

这样就完成了一个组件的联系，可以对这个组件进行逻辑处理

#### 设置监听器

#### 创建Toast提示消息

