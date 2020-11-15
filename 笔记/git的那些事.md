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
git config --global --unset user.name #取消name设置
git config --global --unset user.email #取消email设置
git config --global user.name "username" #注意！冒号不要丢，里面是你的用户名
git config --global user.email youemail@163.com #注意！这里没有冒号！里面是你的游戏
```

当然到这里你可以说结束了，但是如果你使用的是ssh配置的话才刚刚开始，前面是http的配置

我们有必要说一下这个ssh配置：

​        **ecure Shell** (**SSH**) 是一个允许两台电脑之间通过安全的连接进行数据交换的**网络协议**。通过**加密**保证了数据的保密性和完整性。SSH采用**公钥**加密技术来**验证远程主机**，以及(必要时)允许远程主机验证用户。

​	传统的FTP、Telnet是再网络中明文传送数据、用户帐号和密码，很容易受到中间人攻击。

​	SSH是目前较可靠，专为远程登录会话和其他网络服务提供安全jiux性的协议。利用SSH协议可以有效防止远程管理过程中的信息泄露问题。通过**SSH**可以对所有传输的数据进行加密，也能够防止DNS欺骗和IP欺骗。

​	所以第一步就是在本地生成一个ssh 

```shell
    $ ssh-keygen -t rsa -C "youemail@yeah.net"
```

这里你只需要连按三个enter就可以完成，看到一个很奇怪的图

![](https://s1.ax1x.com/2020/10/10/06RR6U.png)

那么恭喜你，你已经在本地的ssh文件夹下生成了这个ssh，但是你会发现你找不到这个ssh文件夹，因为他是隐藏起来的。所以你需要去用命令行去打开这个地方，并且去看他的地址和公匙内容，把这个内容放到github的地方上，这样就完成了ssh配置，就可以愉快的推代码了！

​	第二步我们需要去讲如何查看自己的ssh文件夹中的内容。首先我们在命令行中输入：

```shell
cd ~/.ssh #进入到git配置ssh的目录
dir #查看此目录下的文件有哪些
```

![](https://s1.ax1x.com/2020/10/11/0ck0u6.png)

如果出现这个代表已经生产了ssh都成功了，这里的rsa.pub是代表的是公匙，没有pub的是私匙。一定不要告诉别人私匙哦！

​	第三步我们需要去在本地打开这个文件,或者直接查看 （当然你可以用vim打开，但是复制的时候有些麻烦）

```
cat ~/.ssh/id_rsa.pub # 如果你没有给管理员权限，记得在前面加sudo
```

这样我们就打开了这个文件秘钥 然后复制这段对话，记得不要复制你的邮箱！不要有空格！

​	第三步我们需要添加这个秘钥  

点 Settings

![](https://s1.ax1x.com/2020/10/11/0gjYan.png)

![](https://s1.ax1x.com/2020/10/11/0gj1Kg.png)

点击SSH and GPG  

后面的事情我觉得我不用说了hhh就是点击添加然后复制你的_pub里面的东西 不要复制你的邮箱进去，然后名字填一个有辨识度的就可以。大概这就是配置了。

结束了以后以下是验证步骤：

进入一个新建文件夹，比如新建了一个叫git的文件夹

```shell
cd git
git init #初始化这个仓库
git remote add origin "仓库地址" #别告诉你github/gitee没有建仓库
git add ./ # 记得在里面文件夹放一个read.md文件
git commit -m "init" 
git push origin master
```

一般来说应该能成功，如果是因为error是拒绝连接的问题，建议去看一下代理篇，来解决这个问题。

然后就可以看到一个绿点和你的提交的东西。没有绿点是因为邮箱配置错误，建议检查配置的邮箱。上面有检查方式。

### 关于git代理的那些事

​	在这里，我们重点讲一下代理的事情，如果你会科学上网，当然能理解这个代理的问题。如果你不会科学上网。我真的建议你去看一下科学上网。毕竟咱们是做开发的，似不似得用google。

### 关于推代码的那些事（一）

​	因为最近在开发匣子3.0，所以难免会用到Fork与Pull request的事情来进行开发。而且我想去学习一下关于分支管理等开发的一些规范性问题，所以我们先知道git的工作流程：

​	git是可以进行多重分支开发的，什么意思呢？也就是说git中存在不同的分支，并且可以切换到不同的分支进行开发与推代码。例如在github上大型项目总是有master与develop分支，master分支是用于大版本迭代时所使用发布分支，而develop是开发者所推代码的分支。而git分支的本质就是一个指向commit对象的指针。

例如git add是将文件添加到缓存，也就是将快照的内容写入了缓存，而git commit是执行记录缓存区的快照。

而利用git reset HEAD则是取消已经缓存的内容。

​	那么git是如何知道你是在哪个分支上工作的？ git中保存了一个名为HEAD的指针，HEAD指针指向正在工作的本地分支的指针 利用git checkout命令来进行操作HEAD指针。 git branch命令来查看当前所在的分支 

git checkout  <分支名字>来切换分支。

![](https://s3.ax1x.com/2020/11/15/DivGss.png)

f30ab是最后一次commit后的即将上传的快照，通过HEAD指向master分支可以在master分支提交

在执行git checkout testing时指向了testing分支（当然这些都是本地分支）

​	我们如何将本地dev分支的代码推到remote的dev分支？

```git
git push origin dev:dev  
```

:前面的dev表示本地分支dev 冒号后面的代表

### 关于推代码的那些事（二）

### 什么？居然有人用客户端来推代码？这不是歧视命令行？~~不会吧不会吧，2102年了还有人歧视客户端？~~

所以我们这一节就是要将一些开发所使用的客户端：GitKraken、sourcetree等，不过你当然可以使用IDE的插件来进行推代码，反正总之能推上代码，有绿点就行。



 

 

 



