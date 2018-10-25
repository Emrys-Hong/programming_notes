for details, visit [david camp](https://www.cnblogs.com/mchina/archive/2013/01/30/2880680.html)

# screen install 
```
[root@TS-DEV ~]# yum install screen
[root@TS-DEV ~]# rpm -qa|grep screen
screen-4.0.3-4.el5
[root@TS-DEV ~]#
```

# new screen
```
安装完成后，直接敲命令screen就可以启动它。但是这样启动的screen会话没有名字，实践上推荐为每个screen会话取一个名字，方便分辨：

# screen -S david 

[root@TS-DEV ~]# screen vi david.txt
screen创建一个执行vi david.txt的单窗口会话，退出vi 将退出该窗口/会话。
```

# list all the screen names
```
## list all the windows
ctrl-a + w 
windows looks like this:
0$ bash  1-$ bash  2*$ bash  

Ctrl-a A to rename the windows
```

# detached and recover
```
## detach
ctrl-a + d 

## list all the detached screen and get the number
screen -ls

## recover the screen
screen -r <number>
```

## remove dead screen
```
screen -wipe
```

## kill the screen
```
after you delete every programe in that screen it will automatically kill itself.

## also can use this to kill the current screen
ctrl-a + k
