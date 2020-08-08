## Android请求权限问题

* 概念
* 如何操作
* 源码解析
* 综述

#### 概念

因为Android应用都是在类似于沙盒的中允许，只能访问沙盒内部的资源，如果想要访问沙盒外的资源就需要去请求权限。

在Android 6（不包含Android 6）以下的时候我们经常是当我们安装应用的时候，会提示用户是否允许，当升级应用需要更多权限的时候也会进行一个提示，在Android 6 （包含Android6）以上 ，Google改变了这种请求的做法，列出了一些请求的原则，为了更好的去保护用户的隐私

* 在用户需要互动时再请求对于的权限
* 权限对应某种功能，拒绝此权限不能让用户不能使用APP，只需要拒绝某项功能，并且适当降低应用权限
* 不要假设任何系统行为

在Android 6对于的API是 23，在这里我们可以说SDK可以与API对于，但是二者还是有一些区别，SDK是Software Development Kit（软件开发工具包） API是Application Programming Interface（编程接口）。SDK是程序包，程序包中有一些软件功能，程序包几乎是全封闭的，只有接口可联通外界，这个接口就是API。使用软件功能就通过API。当然在Android SDK可以和API对应起来

常见场景：

* 读取短信信息
* 读取日历表的内容
* 获得通讯录的内容（联系人，手机号码）
* 获取媒体图片

首先我们可以看一下我们模拟器的权限



![](https://s1.ax1x.com/2020/08/08/a5Q0Dx.png)

d 代表的是 directory 目录的意思 -代表的是文件的意思

后面每3个一组  r=read   w=write  x=execute（执行）

第一组是自己的权限、第二组是同组的权限（文件所属的用户组），第三组是除了自己和自己组其他组的

#### 如何操作

* 申明权限

我们需要在ManiFest中申请权限，例如网络请求权限

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

还有一些常见的权限

```xml
<uses-permission android:name="android.permission.READ_CONTACTS"/>         读取联系人
<uses-permission android:name="android.permission.READ_SMS"/>              读取短信内容
<uses-permission android:name="android.permission.DEVICE_POWER"/>          电源管理
<uses-permission android:name="android.permission.CAMERA"/>                拍照
<uses-permission android:name="android.permission.READ_FRAME_BUFFER"/>     屏幕截图
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/> 读外部存储（媒体库
```

* 检查权限

利用checkSelfPermission来检查权限

checkSelfPermission方法返回一个静态int的Permission_Granted（允许）或者Permission_denied（拒绝）

```java
int readPermission = checkSelfPermission(Manifest.permission.READ_CALENDAR);
int writePermission = checkSelfPermission(Manifest.permission.WRITE_CALENDAR);
if (readPermission !=PackageManager.PERMISSION_GRANTED){
//这里表示没有读的权限
}
if (writePermission !=PackageManager.PERMISSION_GRANTED){
//表示没有写的权利后该怎么做
}
```

如果当检查权限的时候，没有权限（返回PERMISSION_DENIED）

Google提供了一种方法：让开发者去说明应用为什么需要这个权限

如果 `ContextCompat.checkSelfPermission()` 方法返回 `PERMISSION_DENIED`，请调用 [`shouldShowRequestPermissionRationale()`](https://developer.android.com/reference/androidx/core/app/ActivityCompat?hl=zh-cn#shouldShowRequestPermissionRationale(android.app.Activity, java.lang.String))。如果此方法返回 `true`，请向用户显示指导界面。请在此界面中说明用户希望启用的功能为何需要特定权限。

* 申请权限

当用户查看指导界面后或 `shouldShowRequestPermissionRationale()` 的返回值表明不需要显示指导界面后，可以请求权限。用户会看到系统权限对话框，并可在其中选择是否向应用授予特定权限

利用requestPermissions来请求权限

```java
  requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISION_REQUEST_CODE);
```

* 查看是否请求成功

```java
 @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==PERMISION_REQUEST_CODE){
            if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                //以下是申请成功的方法
            }
            else {
            }
        }
    }

```

