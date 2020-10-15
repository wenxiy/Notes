## Broadcast

### 什么是广播？

广播是以一种电子通信技术发送信息内容提供给公众的行为。是一种传播媒体。对于Android中的广播来说，一个信息被封装在Intent对象中，我们其实一般可以利用从Intent中读取出来这个字符串从而获得这个信息。在Android中的广播分为标准广播和有序广播。也可以将其分为全局广播和本地广播（一个应用自己发送广播，自己接收广播。）。

### 接收广播与发送广播

* 两种方式接收

在AMF声明接收和动态的注册接收器来接收。

AMF声明接收：

1. 

```xml
<receiver android:name=".MyBroadcastReceiver" android:exported="true">
	<intent-filter>
		<action android:name="android.intent.action.BOOT_COMPLETED"/>
		<action android:name="android.intent.action.INPUT_METHOD_CHANGED"/>
	</intent-filter>
</receiver>
```

2. 创建子类并实现方法。

```java
public class MyBroadcastReceiver extends BroadcastReceiver{
 	private static final String TAG =“MyBroadcastReceiver”；
        @Override
        public void onReceive(Context context,Intent intent){
    	StringBuilder sb = new StringBuilder();
        sb.append(wsd)
    }
}
```



注册接收器：



* 三种方式发送

标准广播：

有序广播：

Sticky广播：

* 