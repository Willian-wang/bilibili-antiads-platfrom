# bilibili-antiads-platfrom
## B站直播间反广告平台~

好吧~ 这只是练手的小项目。  
技术含量不是很高，但是，作为一个正规项目，该有的东西都得有。  
写的比较简单，比较适合新人拿来参考~

---

### 一、使用指南
注意：目前还处于测试期，服务可能不太稳定，也存在清除数据的可能，请谨慎使用。
1. 服务器ip：129.204.189.135:8080
2. 在指定的API下，使用Requestbody向服务器发起请Ajax请求即可。（请求不可以为空）
3. 后期加入身份验证后需要使用cookies，添加SessionId字段即可。

### 二. API列表
#### 1. 已实现
<table boder="1" >
<tr style="text-align:center">
<td><b>路径</b></td>
<td><b>方法</b></td>
<td><b>解释</b></td>
<td><b>字段</b></td>
</tr>
<tr>
<td rowspan="3">/banneduid</td>
<td>POST</td>
<td>添加封禁ID</td>
<td><pre>{
    "Uid":"String"
    //广告君的UID
    "text":["String",String]
    //广告君生前所发的文本
}</pre></td>
</tr>
<tr>
<td>GET</td>
<td>获取封禁ID列表</td>
<td><pre>{
    "id":"Long"
    //这个是服务器内部生成的主键ID
}</pre></td>
</tr>
</tr>
<tr>
<td>DELET</td>
<td>撤销ID封禁<br>（用于误封）</td>
<td><pre>{
    "Uid":"String"
    //被认为是广告君的无辜群众的UID
}</pre></td>
</tr>
</table>

### 三、项目情况

因为最近事情比较多，同时在维护三个项目TAT，因此，这个能写尽量多写一些吧。也比较欢迎愿意各位大大贡献代码。 

这个项目，最开始（至少目前）的定位为用爱发电的公益项目。目前跑在腾讯云的学生机里。 

#### 1. 技术栈

毕竟是面向新人的项目，在这里介绍一下使用的技术栈。
可以根据以下列表在网上找到相关资料

1. Spring Boot + MyBatis*
2. Redis
3. Mysql*
4. Nginx*
5. docker*

加 * 的为目前还没有使用到的技术栈。
目前还没有上数据库，几乎所有数据都存在redis。

因为服务器成本较低，高并发和高可用就目前来看暂时不考虑。
容器化，则在正式上线之后可以考虑。
如果之后可以收到捐助或者是可以盈利的话可以搞点事情。

之后，如果有必要，则会考虑使用K8S，服务器集群来做一个高可用和高并发。（反正也知道怎么用，上一个项目有用到。

#### 2. 各模块完成情况
##### 1）. 已完成模块
1. 添加，查询，删除封禁用户

##### 2）. 计划完成模块

1. 封禁规则生成模块
    使用随机损失算法自动生成
2. 用户身份验证
    就是前面提到的SessionId啦
3. 注册模块
4. 定时任务模块
    将Redis的缓存，定时写入数据库中。
5. 流量限制模块
    使用令牌桶或计数器来做一个流量限制。
6. 循环封禁名单生成
7. 用户关注，被关注
   关注某一或某几个SessionID，只从这几个SessionID中获取封禁名单与规则
8. 该平台的UI界面。

以上~想到再加