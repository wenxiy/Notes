## Broadcast

### 什么是广播？

广播是以一种电子通信技术发送信息内容提供给公众的行为。是一种传播媒体。对于Android中的广播来说，一个信息被封装在Intent对象中，我们其实一般可以利用从Intent中读取出来这个字符串从而获得这个信息。在Android中的广播分为标准广播和有序广播。

### 接收广播与发送广播

* 两种方式接收

在AMF声明接收和动态的注册接收器来接收。

AMF声明：

```xml
<receiver android:name=".MyBroadcastReceiver" android:exported="true">
	<intent-filter>
		<action android:name="android.intent.action.BOOT_COMPLETED"/>
		<action android:name="android.intent.action.INPUT_METHOD_CHANGED"/>
	</intent-filter>
</receiver>
```



* 三种方式发送

标准广播：

有序广播：

Sticky广播：

* 