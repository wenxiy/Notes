#### JVM组成及作用
* 定义：Java Virtual Machine 即Java虚拟机，每个操作系统上配备一个JVM，从而达到跨平台的作用。
* 与jre，jdk的关系：
1.JRE是指：Java Runtime Environment 即Java运行环境。JRE=JVM+核心类库。
2.JVM是指: Java Development Kit 即Java开发工具包。JDK=JRE+Java开发工具（Javac.exe）
故我们想编写JAVA代码就可以直接安装JDK即可。
* 组成：运行时数据区，类加载器，执行引擎，本地接口
![示意图](https://img2020.cnblogs.com/blog/897500/202003/897500-20200316153915356-1960658745.png)
* 作用：我们要想弄清楚JVM各个组成的功能，必须先去弄清楚JVM它的整体作用
1.整体：JVM主要是用来解释自己的指令集（即字节码）到CPU指令集或者OS的系统调用。指令集包含在JAVA源文件生成的类文件（.class）
2.类的生命周期：加载、验证、准备、解析、初始化、使用、卸载。其中验证、准备和解析又统称为连接阶段
* 加载：加载是JVM利用字节码文件创建一个Class对象。
* 验证：确保class文件字节流包含信息符合JVM的要求，不会危害JVM的自身安全。
* 准备：分配内存，并初始化为0（还没加载更多的）
* 解析：将常量池中的符号引用替换为直接引用。
* 初始化这个阶段，JVM虚拟机给出了5种必须对类进行“初始化”的情况
使用new关键字实例化对象的时候、读取或设置一个类的静态字段的时候、调用一个类的静态方法的时候；
使用java.lang.reflect包的方法对类进行反射调用的时候，如果类没有进行过初始化，则要先触发其初始化；
当初始化一个类的时候，如果发现其父类还没有被初始化，则要先初始化其父类。
当虚拟机启动时，用户需要指定一个执行的主类（包含main方法的那个类），则虚拟机会优先初始化这个主类；
在JDK1.7以后，动态语言支持的时候，如果一个java.lang.invoke.MethodHandle实例最后的结果是要执行第1种情况的操作，则也要进行初始化。
### 类加载器（Classloader）：读取类的二进制流到JVM中
分为三类：
1. Bootstrap启动类加载器：
* C++实现
* 将lib下的核心库或者Xbootclasspath参数下指定的JRE包加载到内存上
* 具体加载的路径可以通过System.getProperty("sun.boot.class.path")来查看
2. Extension类加载器：
* JAVA实现
* 负责加载<JAVA_HOME>/lib/ext目录下或者由系统变量-Djava.ext.dir指定位路径中的类库
* System.getProperty("java.ext.dirs")
3. System类加载器：
* sun公司的AppClassLoader实现
* 负责加载系统类路径java -classpath或-D java.class.path 指定路径下的类库
* System.getProperty("java.class.path")
(注：还可以自定义类加载器，而且类加载器的实现是双亲委派模式)
类加载器的参考：
https://blog.csdn.net/justloveyou_/article/details/72217806
https://blog.csdn.net/javazejian/article/details/73413292
### 运行时数据区（Runtime Data Area）
分为：
* 堆：对象的存储区域，使用new字段分配java的实例和数组都被分配到堆中。
* 方法区：用于存储已被虚拟机加载的类信息，常量，静态变量，即时编译器编译后的代码等数据。
* JAVA栈：
* 程序计数器：
* 
