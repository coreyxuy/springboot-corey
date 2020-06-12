## 项目说明

#### 1.版本说明
springboot 2.0.5

#### 2.项目启动
    启动项目前,确保mq是开启的和redis开启状态 默认访问地址即可
    直接运行启动类
    
#### 3.项目常用地址
1.swagger地址: http://localhost:8081/swagger-ui.html#/
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200602194521698.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_1,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0NvcmV5WHV1,size_5,color_FFFFFF,t_10)
        
2.mq客户端:    http://127.0.0.1:8161/admin/
默认admin/admin   

3.Druid德鲁伊sql监控地址;http://localhost:8007/druid/api.html


### 4.项目整合框架
1. 整合activemq 的两种消息发送类型 点对点 和 发布订阅
2. 整合redis加载启动和常用配置表信息加载到缓存和springboot容器
3. springboot 发送电子邮件的
4. 整合swagger-ui2
3. 整合mybatis的逆向工程
4. 整合springboot上传图片
5. 整合logback框架日志系统
6. 整合分页插件 pagehelper
7. 整合定时任务框架Quartz
8. 添加统一返回类R
9. 添加druid连接池监控
   
     

