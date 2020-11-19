利用matlab的cftool工具箱进行函数拟合

```matlab
%第一步：先给出拟合数据
M=xlsread('Attach3.xlsx');
P=M(:,1);
E=M(:,2);
%调用cftool工具箱
cftool 
```

选择需要拟合的函数类型：线性、高斯等

![](https://s1.ax1x.com/2020/09/08/wQUVJI.png)

![](https://s1.ax1x.com/2020/09/08/wQUh0e.png)

选择自变量和因变量

最后得到曲线图像和拟合结果