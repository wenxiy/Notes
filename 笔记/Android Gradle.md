## Android Gradle 

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



