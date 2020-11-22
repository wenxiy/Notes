## Android Gradle解析 

### Gradle入门

Gradle是基于Groovy语言实现的一种构建系统工具，大部分构建功能通过插件的方式来实现，十分的灵活。学习前需要Java以及开发Android APP的基础

* 环境配置

在这里默认已经配置了Java的JDK环境（建议将PATH都写在/etc/profile），再其次我们要去官网下载其Gradle Bulid Tool，用来构建Gradle。打开gradle.org/install 去安装任意版本的Gradle Tool，在这里我安装的是Gradle v-6.7。解压到usr或者home目录

然后配置Gradle的环境PATH

```shell
vi /etc/profile.d/gradle.sh
GRADLE_HOME=/root/gradle-4.4.1
PATH=$GRADLE_HOME/bin:$PATH
export PATH GRADLE_HOME
chmod +x /etc/profile.d/gradle.sh
source /etc/profile.d/gradle.sh
```

不知道为什么，每次我重启调用Gradle的时候就是要写下这一个

```shell
sudo source /etc/profile
```

最后测试：

```shell
gradle -version
>> Welcome to Gradle 6.7!

Here are the highlights of this release:
 - File system watching is ready for production use
 - Declare the version of Java your build requires
 - Java 15 support

For more details see https://docs.gradle.org/6.7/release-notes.html


------------------------------------------------------------
Gradle 6.7
------------------------------------------------------------

Build time:   2020-10-14 16:13:12 UTC
Revision:     312ba9e0f4f8a02d01854d1ed743b79ed996dfd3

Kotlin:       1.3.72
Groovy:       2.5.12
Ant:          Apache Ant(TM) version 1.10.8 compiled on May 10 2020
JVM:          11.0.8 (Oracle Corporation 11.0.8+10-LTS)
OS:           Linux 4.15.0-30deepin-generic amd64


```

#### Warpper脚本

* 定义：

  * Wraaper是对Gradle包装的一个脚本。可以通过此来控制Gradle的版本不一致的问题。

* 使用

  * 在使用shell命令来自动生产Wrapper的目录文件:

  ```
  gradle wrapper
  ```

  在执行此命令以后生成如下文件：

  gradle-wrapper.jar（Gradle业务逻辑的具体实现的jar包）

  gradle-wrapper.properties（Gradle配置文件，来配置哪个版本的Gradle）

  gradlew（linux下执行Gradle的脚本）

  gradlew.bat（Windows下执行Gradle的脚本）

  在协作开发的时候去提交jar包以去让其他开发人员去配置使用

* 如何通过Warpper指定版本

  * 通过gradle--wrapper--gradle-version命令来指定使用的Gradle版本
  * 通过gradle--wrapper--gradle-distribution-url 来指定下载Gradle发行版的url
  * 如果不采用任何参数--gradle wrapper不添加参数，就是来用当前的gradle作为wrapper的gradle version

* 详解gradle--Wrapper.properties

  在gradle--Wrapper.properties中有很多字段，通过对字段的定义达到一种配置的目的

  * distributionBase:下载的Gradle压缩包解压的主目录
  * distributionPath:压缩包路径
  * zipStoreBase:放aip压缩包
  * ........Path:路径
  * distributionUr:下载Gradle的版本地址，可以改为国内镜像。

#### Groovy基础

在这里Groovy有很强大的类型推导机制，对于不同的类型通过标识式就可以进行推导

* 字符串：单引号只是字符串，双引号是运算符但也可以表示字符串。例如：

  ```groovy
  task printStringClass<<{
      def name = "张三" //标识符是”“或者'
      println '单引号不能表示计算${name}'
      println "双引号可以表示计算${name}"
  }
  输出：
  单引号不能表示计算${name}
  双引号可以表示计算张三
  ```

* 集合：对于集合来说，标识符是[]

  * list:

    ```groovy
    task printlist <<{
        def numlist=[1,2,3,4,5] //numlist = new ArrayList<>();
        println numlist.getClass.name();
    }
    ```

    遍历：类似于数组遍历

    ```groovy
    numList[1] //第二个元素
    numList[2] //第三个元素
    numList[1..4] //第二个到第四个元素
    numList[-1] //右侧数第一个
    ```

    迭代：接收闭包参数的each方法

    ```groovy
    task printlist <<{
        def numlist=[1,2,3,4,5] //numlist = new ArrayList<>();
        println numlist.getClass.name();
        println numList[1] //第二个元素
    	println numList[2] //第三个元素
    	println numList[1..4] //第二个到第四个元素
    	println numList[-1] //右侧数第一个
    	numList.each{
            println it //出现it关键字
    	}
    }
    ```

* Map

  * 键值对应定义：

  ```groovy
  task printlnMap<< {
      def map =['K':V,'K1':V1]
      println map.getClass().name
  }
  ```

  * 遍历：

  ```groovy
  map.K1或者map[k1]
  ```

  * 迭代

  ```groovy
  map.each{
      println "${it.key},{it.value}"
  }
  ```

* 方法：

  * 在使用方法中参数括号是可以省略的，但定义方法中基本都需要写，除非传递的是闭包类型
  * 在方法中return是可以不写的
  * 在方法中代码块是可以传递的

  ```groovy
  task test<<{
      def add1 = method 1,2
  }
  def method(int a,int b){
      if (a>b){ //在Kotlin中if省略return和这个不同 if代表的是一个表达式 所以可以省略return
          a//而这里是代表整体的return都是可以不写的
      }
      if (a<b){
          b
      }
  }
  ```

  最后利用./gradlew命令来执行task

  关于最后一点，传递代码块有必要说一下，代码块传递就是闭包的传递，是传递的代码块。在Groovy中定义了两种规则：

  * 如果使用一个方法，并且这个方法最后一个参数是闭包，那么可以将这个闭包放到方法的外面

  ```groovy
  numlist.each (){
      println it //这个花括号里面的代码就是代码块就是闭包
  }
  初始写法：
  numlist.each({println it})
  ```

  * 如果使用一个方法，并且这个方法最后一个参数是闭包，那么可以将这个方法括号省略

  ```groovy
  numlist.each{
      println it
  }
  ```

  说完了在方法中传递代码块（闭包），那么我们系统的说一下闭包。

* 闭包

  * 什么是闭包？闭包有两方面构成：一段代码块和引用了自由变量的函数。对于Groovy中我们常用的就是代码块。
  * 如何使用？

  1. 当闭包只有一个参数的时候，则记为it变量，当具有多个变量的时候，就需要一一列出。

  ```groovy
  def eachMap(closure){
      def map1  {"name":"张三","age":18}
      map1.each{
          closure(it.key.it.value)//Closure是groovy.lang下的一个抽象类
      }
  }
  ```

  * 闭包中最重要的特性：委托

  1. 什么是委托？

  2. 如何体现委托

     什么是委托？委托模式中，有两个对象参与处理同一个请求，接受请求的对象将请求委托给另一个对象来处理。这也就是代理模式

     如何体现委托？

     在闭包（Closure）中有三个属性thisObject、owner、delegate

     在默认情况下，先调用thisObject来处理闭包中的方法，而delegate和owner是对等，但是owner优先级高于delegate

     示例代码分析：

     ```
     task helloDelegate<<1{
         new Delegate().test{
             
         }
     }
     ```

     

  