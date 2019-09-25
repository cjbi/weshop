WESHOP |  基于微服务的小程序商城系统
---
Weshop是基于Spring Cloud(Greenwich)开发的小程序商城系统，提供整套公共微服务服务模块，包含用户中心、商品中心、订单中心、支付中心四大基础服务模块，微信端、管理平台两大聚合服务模块，支持服务治理、监控和追踪等功能。

## 请注意

管理平台功能还没有实现，很多功能未完善，没太多时间维护。感兴趣的Fork一份自己完善。

## 组织结构

```
weshop
├── weshop-common -- 框架公共模块
├── weshop-eureka-server -- eureka注册中心[端口:8761]
├── weshop-config-server -- 配置中心
├── weshop-api-gateway -- api网关[端口:8020]
├── weshop-hystrix-dashboard -- 断路器监控面板[端口:1301]
├── weshop-example -- 项目示例工程
|    ├── weshop-example-api -- 远程服务api接口
|    ├── weshop-example-provider -- 服务提供方[端口:9998]
|    ├── weshop-example-consumer -- 服务消费方[端口:9999]
├── weshop-user-api -- 用户中心api
├── weshop-user -- 用户中心基础服务
├── weshop-goods-api -- 商品中心api
├── weshop-goods -- 商品中心基础服务
├── weshop-order-api -- 订单中心api
├── weshop-order -- 订单中心基础服务
├── weshop-storage-api -- 对象存储服务api
├── weshop-storage -- 对象存储服务
├── weshop-wechat -- 微信端聚合服务
├── weshop-wechat-ui -- 微信小程序页面
├── weshop-admin -- 管理平台聚合服务
├── weshop-admin-ui -- 管理平台页面
├── weshop-pay-api -- 支付中心api
├── weshop-pay -- 支付中心基础服务
```

> 模块划分

![](docs/images/模块划分.png)

### 后端技术

技术 | 名称 | 版本 | 官网
----|------|----|----
Spring Boot | 应用框架 | 2.1.2.RELEASE | [https://projects.spring.io/spring-boot/](https://projects.spring.io/spring-boot/)
spring-cloud-netflix | 微服务框架 | Greenwich.RELEASE | [https://projects.spring.io/spring-cloud/](https://projects.spring.io/spring-boot/)
MyBatis | ORM框架 | 3.2.1 |  [http://www.mybatis.org/mybatis-3/zh/index.html](http://www.mybatis.org/mybatis-3/zh/index.html)
Mapper | MyBatis 通用 Mapper4 | 4.0.0 |  [https://gitee.com/free/Mapper](https://gitee.com/free/Mapper)
MyBatis Generator | 代码生成 | 1.3.5 |  [http://www.mybatis.org/generator/index.html](http://www.mybatis.org/generator/index.html)
Swagger2 | 在线Api文档 | 2.9.2 |  [https://swagger.io/](https://swagger.io/)
Thymeleaf | 模板引擎 | 3.0.9.RELEASE |  [https://www.thymeleaf.org/](https://www.thymeleaf.org/)
Logback | 日志组件 | 1.1.3 |  [https://logback.qos.ch](https://logback.qos.ch/)
Druid | 数据库连接池 | 0.2.23 |  [https://github.com/alibaba/druid](https://github.com/alibaba/druid)
Hibernate Validator | 后端校验框架 | 5.4.2.Final | [http://hibernate.org/validator/](http://hibernate.org/validator/)
RabbitMQ | 消息中间件 | 5.4.3 | [http://www.rabbitmq.com/](http://www.rabbitmq.com/)
Redis | 缓存 | 5.0.3 | [https://redis.io/](https://redis.io/)
Zipkin | 链路追踪 | 2.12.0 | [https://zipkin.io/](https://zipkin.io/)

### 前端技术

技术 | 名称 | 版本 |  官网
----|------|----|----
React | 前端MVC框架 | 16.5.1 |  [https://reactjs.org/](https://reactjs.org/)
Ant Design Pro | 开箱即用的中台前端/设计解决方案 | 2.1.0 |  [https://pro.ant.design/index-cn](https://pro.ant.design/index-cn)

### 软件需求

- JDK1.8+
- MySQL5.6+
- RabbitMQ 3.6.x+
- Maven3.0+
- ZipKinServer 3.7.0+

## 功能

### 商城功能

- 首页
- 专题列表、专题详情
- 分类列表、分类详情
- 品牌列表、品牌详情
- 新品首发、人气推荐
- 搜索
- 商品详情、商品评价、商品分享
- 购物车
- 下单
- 订单列表、订单详情
- 地址、收藏、足迹、意见反馈
- 客服

### 管理平台功能(未完成)

-  [ ]  会员管理
-  [ ]  商城管理
-  [ ]  商品管理
-  [ ]  推广管理
-  [ ] 系统管理

## 当前进度与计划

- [ ]  公众号文章同步
- [x]  文章列表、文章详情展示
- [x]  分享、点赞、收藏功能实现
- [x]  评论相关展示和功能实现
- [x]  生成海报功能的实现
- [x]  评论消息通知功能的实现
- [x]  专题、标签相关功能的实现
- [ ]  后台管理功能实现

### 在线演示

。。。

### 预览图

> 服务注册页面

![](docs/preview/eureka.JPG)

> swagger

![](docs/preview/swagger.gif)

> 首页

![](docs/preview/index.gif)

> 商品页

![](docs/preview/detail.gif)

> 购物车页

![](docs/preview/orderlist.JPG)

## 安装教程

### 本地部署

1. 通过git下载源码
2. 创建数据库weshop，数据库编码为UTF-8
3. 执行docs/sql/data.sql文件，初始化数据
4. 修改配置中心(weshop-config-server)的database.properties和common.properties文件，更新MySQL账号和密码，更新RabbitMQ配置，更新zipkinServer配置
5. 运行Maven命令mvn install(注意：安装weshop-admin模块因为会运行npm install和npm build命令时间会比较长，当然也可以手动在weshop-admin模块执行npm命令)
6. 安装weshop-admin-ui模块，运行mvn install和mvn build命令，运行命令前需要安装nodeJs
7. 运行weshop-eureka-server、weshop-config-server、weshop-api-gateway这几个基础服务
8. 运行weshop-user、weshop-goods、weshop-order、weshop-pay这几个api服务
9. 运行weshop-wechat、wechat-admin这几个endpoint
10. http://localhost:8027/index.html访问后台管理，http://localhost:8020/weshop/swagger-ui.html访问Swagger页面
11. 打开微信开发者工具，导入weshop-wechat-ui模块,点击编译即可，此时可以预览商城效果

使用脚本启动: 
1. 执行命令 `mvn clean package -P env-prd` 生成target文件夹包含项目所有jar包和执行脚本
2. 设置权限 `chmod +x -R target/`
4. 切换到target目录 `cd target/`
3. 启动: `startup-all.sh` 停止: `shutdown-all.sh`

### 生产部署

最低部署要求  1C2G x3

### 获取代码

https://github.com/cjbi/weshop

https://gitee.com/cjbi/weshop

## 许可证

Weshop 使用 MIT 许可证发布，用户可以自由使用、复制、修改、合并、出版发行、散布、再授权及贩售 Weshop 及其副本。

[查看许可证](LICENSE "LICENSE")
