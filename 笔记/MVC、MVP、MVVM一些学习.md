#### MVC、MVP、MVVM设计模式总结
* MVP、MVC、MVVM概念
* 几者之间的对比
* 使用实例
### MVC、MVP、MVVM概念
1.MVC（Model-View-Controller）：Model代表数据模型，View代表视图，用于展示界面，接收用户输入，所以有Activity（接收用户输入），.XML布局文件。Controller代表控制，进行View与Model的交互，进行逻辑处理
2.MVP（Model-View-Presenter）：Model是代表业务逻辑和实体模型，表示的是数据模型，View是视图层，一种视图，包含Presenter的引用
3.MVVM（Model-View-ViewModel）：基本上与MVP完全一致，将逻辑处理层改名为ViewModel
### 几者之间的对比
1.MVC与MVP
* MVP分离了Activity的View层和Controller从而对Activity优化。而Presenter如何实现呢？通过接口来实现此层
![示意图](https://upload-images.jianshu.io/upload_images/944365-0ed874cb3287a7e2.png?imageMogr2/auto-orient/strip|imageView2/2/w/935/format/webp)
* MVP模式的优点：
①.耦合度低：完全隔离了View和Model层，互不干涉
②.简化Activity
2.MVC与MVVM
* 为了更加分离M层与V层，出现了MVVM
* 基本上与 MVP 模式完全一致，将逻辑处理层 Presenter 改名为 ViewModel
![示意图](https://upload-images.jianshu.io/upload_images/944365-7d287d01a52a4f38.png?imageMogr2/auto-orient/strip|imageView2/2/w/1046/format/webp)
具体：https://www.jianshu.com/p/f17f5d981de7

