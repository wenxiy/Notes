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

* 字符串：单引号只是字符串，双引号是运算符但也可以表示字符串。例如：

  ```groovy
  task printStringClass<<{
      def name = "张三"
      println '单引号不能表示计算${name}'
      println "双引号可以表示计算${name}"
  }
  输出：
  单引号不能表示计算${name}
  双引号可以表示计算张三
  ```

* 集合：