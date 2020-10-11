## git的那些事

### 关于初始配置的那些事

​	最近，我又重装了一个linux系统—deepin系统。这个系统最大的好处就是~~等QQ~~不仅继承了优秀的UI设计，而且自带了wine，有很多兼容性软件可以直接在应用商城去下载，最重要的一点是用的是linux的内核，舒适的命令行与linux的自带“服务器”属性。但是在git配置的时候（我已经很长时间没有重新配置过git了）出现了各种各样的问题，想做一个关于配置的一个教程，并且学会如何去查看自己是否配置正确。

​	首先，我们需要在deb系下的系统（ubuntu或deepin）安装一下git

```shell
sudo apt-get update 
sudo apt-get install git
```

第一行shell是表示在apt软件包下更新一下所有的源。第二行shell是表示在apt软件包下安装git

最后我们查看一下是否安装了git

```shell
git --version
```

如果安装成功，则会显示：git version 2.11.0  (当然版本号可能会不一样)

​	第二步，我们再看一下自己的github/gitee的用户名和注册邮箱，并且config一下。首先我们看一下自己以前有没有挂载过git(新系统的话就暂时不需要了

```shell
git config --global --list #这语句就是看你有没有配置过git如果有的话不能推代码的话建取消
git config --global --unset user.name#取消name设置
git config --global --unset user.email#取消email设置
git config --global user.name "username" #注意！冒号不要丢，里面是你的用户名
git config --global user.email youemail@163.com #注意！这里没有冒号！里面是你的游戏
```

当然到这里你可以说结束了，但是如果你使用的是ssh配置的话才刚刚开始，前面是http的配置

我们有必要说一下这个ssh配置：

​        **ecure Shell** (**SSH**) 是一个允许两台电脑之间通过安全的连接进行数据交换的**网络协议**。通过**加密**保证了数据的保密性和完整性。SSH采用**公钥**加密技术来**验证远程主机**，以及(必要时)允许远程主机验证用户。

​	传统的FTP、Telnet是再网络中明文传送数据、用户帐号和密码，很容易受到中间人攻击。

​	SSH是目前较可靠，专为远程登录会话和其他网络服务提供安全性的协议。利用SSH协议可以有效防止远程管理过程中的信息泄露问题。通过**SSH**可以对所有传输的数据进行加密，也能够防止DNS欺骗和IP欺骗。

所以第一步就是在本地生成一个ssh 

```shell
    $ ssh-keygen -t rsa -C "youemail@yeah.net"
```

这里你只需要连按三个enter就可以完成，看到一个很奇怪的图

 ![](https://imgchr.com/i/06RR6U)

那么恭喜你，你已经在本地的ssh文件夹下生成了这个ssh，但是你会发现你找不到这个ssh文件夹，因为他是隐藏起来的。所以你需要去用命令行去打开这个地方，并且去看他的地址和公匙内容，把这个内容放到github的地方上，这样就完成了ssh配置，就可以愉快的推代码了！

### 关于git代理的那些事

### 关于推代码的那些事（一）

### 关于推代码的那些事（二）

### 什么？居然有人用客户端来推代码？这不是歧视命令行？~~不会吧不会吧，2102年了还有人歧视客户端？~~

所以我们这一节就是要将一些开发所使用的客户端：Github Desktop、sourcetree等



 

 

 



