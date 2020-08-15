## Android请求权限问题

* 概念
* 如何操作
* 源码解析

### 概念

因为Android应用都是在类似于沙盒的中允许，只能访问沙盒内部的资源，如果想要访问沙盒外的资源就需要去请求权限。

在Android 6（不包含Android 6）以下的时候我们经常是当我们安装应用的时候，会提示用户是否允许，当升级应用需要更多权限的时候也会进行一个提示，在Android 6 （包含Android6）以上 ，Google改变了这种请求的做法，列出了一些请求的原则，为了更好的去保护用户的隐私

* 在用户需要互动时再请求对应的权限
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

### 如何操作

#### 申明权限 

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

#### 检查权限

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

#### 申请权限

当用户查看指导界面后或 `shouldShowRequestPermissionRationale()` 的返回值表明不需要显示指导界面后，可以请求权限。用户会看到系统权限对话框，并可在其中选择是否向应用授予特定权限

我们先申请这个权限：

 ` requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISION_REQUEST_CODE);`

关于`shouldShowRequestPermissionRationale()`方法发现了一个很神奇的事情

如果我们在代码中这么写

```java
 private void checkPermission() {
        //checkSelfPermission方法返回一个静态的Permission_Granted（允许）或者Permission_denied（拒绝）
        int readExStoragePermissonRest = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
        //许可授权的结果返回给readExStoragePermissonRest
        /**
         * 如果访问的结果是拒绝，那么就请求这个权限
         */
        if (readExStoragePermissonRest != PackageManager.PERMISSION_GRANTED) {
            /**
             * READ_EXTERNAL_STORAGE是外部的存储
             */
            shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE);
            Log.d(TAG, "result" + "----->" +shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE));
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 	 
            PERMISION_REQUEST_CODE);
        }


    }
```

我们查看log日志：

`D/.MainActivity: result----->false`

显示的是false

这里我们就要知道权限的种类

权限分为：

* 允许：通过
* 拒绝：拒绝了**但是还要询问**
* 禁止：拒绝了且**不再询问**

这个方法大部分时候都会返回false，只有当用户**拒绝**了权限，才能够返回true来进行引导

也就是说当我们第一次点了拒绝以后，我们就把这个方法的结果设为了true，我们就可以判断这个参数，从而进行引导界面的跳转

总结一下，各种返回情况是：

* 没有请求这个权限，那用户不一定拒绝，那么我就不用去说明，所以`shouldShowRequestPermissionRationable`返回的是false

* 第一次我允许了这个权限，我允许了就不用再去解释为什么需要这个权限，所以我的`shouldShowRequestPermissionRationale`返回值是false
* 第一次我点了拒绝这个权限，并且点了不再弹出，那么就相当于我的禁止，所以我也不会给你去解释这个权限，所以我的`shouldShowRequestPermissionRationale`返回值是false
* 第一次我点了拒绝这个权限，但是我没有点不再弹出，这个时候`shouldShowRequestPermissionRationale`就返回true，从而去进行引导

#### 查询权限是否申请成功

```java
 @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==PERMISION_REQUEST_CODE){
            if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                //以下是申请成功
            }
            else {
                //以下是申请失败
            }
        }
    }

```

### 源码解析

我们先来看一下申请权限requestPermissions的源码

```java
 public final void requestPermissions(@NonNull String[] permissions, int requestCode) {
        if (requestCode < 0) {
            throw new IllegalArgumentException("requestCode should be >= 0");
        }
        if (mHasCurrentPermissionsRequest) {
            Log.w(TAG, "Can request only one set of permissions at a time");
            // Dispatch the callback with empty arrays which means a cancellation.
            onRequestPermissionsResult(requestCode, new String[0], new int[0]);
            return;
        }
        Intent intent = getPackageManager().buildRequestPermissionsIntent(permissions);
        startActivityForResult(REQUEST_PERMISSIONS_WHO_PREFIX, intent, requestCode, null);
        mHasCurrentPermissionsRequest = true;
    }
public Intent buildRequestPermissionsIntent(@NonNull String[] permissions) {
        if (ArrayUtils.isEmpty(permissions)) {
           throw new IllegalArgumentException("permission cannot be null or empty");
        }
        Intent intent = new Intent(ACTION_REQUEST_PERMISSIONS);
        intent.putExtra(EXTRA_REQUEST_PERMISSIONS_NAMES, permissions);
        intent.setPackage(getPermissionControllerPackageName());
        return intent;
    }
```

首先这个是没有返回值的，而且我们规定requestcode的值要大于等于0

其次我们在这个方法中创建了一个Intent，先利用getPackageManager来获取一个PackageManager对象（PackageManager服务管理的类，用于管理应用程序包。通过此我们来获取应用程序的信息，而且获取的信息都来自AndroidManifest文件）

利用packageManager调用方法来将Permission放进intent，然后返回这个intent

startActivityForResult进行数据的传输，当发送了这个广播的时候，我们就会调用权限动态调用申请的界面

这个是利用GrantPermissionsActivity来完成的，这个界面就是常见的申请权限的界面

### 综述

1. 申明权限
2. 检查权限（checkSelfPermission）
3. 申请权限（requestPermissions）
4. 检查是否申明成功（onRequestPermissionsResult）



