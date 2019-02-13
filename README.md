WESHOP |  基于微服务的小程序商城系统
---
Weshop致力于打造可定制化的免费开源商城系统，让天下没有难做的生意。目前还在开发阶段。

## 软件架构

### 服务端口



### 后端技术

技术 | 名称 | 版本 | 官网
----|------|----|----
Spring Boot | 应用框架 | 2.0.0.RELEASE | [https://projects.spring.io/spring-boot/](https://projects.spring.io/spring-boot/)
MyBatis | ORM框架 | 3.2.1 |  [http://www.mybatis.org/mybatis-3/zh/index.html](http://www.mybatis.org/mybatis-3/zh/index.html)
Mapper | MyBatis 通用 Mapper4 | 4.0.0 |  [https://gitee.com/free/Mapper](https://gitee.com/free/Mapper)
PageHelper | MyBatis 分页插件 | 5.1.2 |  [https://gitee.com/free/Mybatis_PageHelper](https://gitee.com/free/Mybatis_PageHelper)
MyBatis Generator | 代码生成 | 1.3.5 |  [http://www.mybatis.org/generator/index.html](http://www.mybatis.org/generator/index.html)
Swagger2 | 在线Api文档 | 2.7.0 |  [https://swagger.io/](https://swagger.io/)
Maven | 项目构建管理 | 4.0.0 |  [http://maven.apache.org](http://maven.apache.org/)

### 前端技术

技术 | 名称 | 版本 |  官网
----|------|----|----
React | 前端MVC框架 | 16.5.1 |  [https://reactjs.org/](https://reactjs.org/)
Ant Design Pro | 开箱即用的中台前端/设计解决方案 | 2.1.0 |  [https://pro.ant.design/index-cn](https://pro.ant.design/index-cn)

### 模块介绍

1. weshop-admin

管理平台前端代码，使用Ant Design Pro开发。

2. weshop-api-server

Api服务后台，使用Spring Boot 2.0 + Mybatis

3. weshop-frontend-app

微信小程序端

### 软件需求

- JDK1.8+
- MySQL5.6+
- Maven3.0+

## 功能

### 商城功能

- 首页
- 专题列表、专题详情
- 分类列表、分类详情
- 品牌列表、品牌详情
- 新品首发、人气推荐
- 团购
- 搜索
- 商品详情、商品评价、商品分享
- 购物车
- 下单
- 订单列表、订单详情
- 地址、收藏、足迹、意见反馈
- 客服

### 管理平台功能

- 会员管理
- 商城管理
- 商品管理
- 推广管理
- 系统管理

### 在线演示

。。。

### 本地部署

## 安装教程

### 本地部署
1. 通过git下载源码
2. 创建数据库weshop，数据库编码为UTF-8
3. 执行docs/sql/data.sql文件，初始化数据
3. 修改application-dev.properties文件，更新MySQL账号和密码
4. 运行Maven命令mvn install(注意：安装weshop-admin模块因为会运行npm install和npm build命令时间会比较长，当然也可以手动在weshop-admin模块执行npm命令)
5. 运行WeshopApplication类，启动项目
6. http://localhost:8080/weshop/index.html访问后台管理，http://localhost:8080/weshop/swagger-ui.html访问Swagger。
7. 打开微信开发者工具，导入weshop-frontend-app模块,点击编译即可，此时可以预览商城效果。

### 配置开发环境

。。。


## 目前开发进度

#### 商城功能

- 首页 0%
- 专题列表、专题详情 0%
- 分类列表、分类详情 0%
- 品牌列表、品牌详情 0%
- 新品首发、人气推荐 0%
- 团购 0%
- 搜索 0%
- 商品详情、商品评价、商品分享 0%
- 购物车 0%
- 下单 0%
- 订单列表、订单详情 0%
- 地址、收藏、足迹、意见反馈 0%
- 客服 0%

#### 管理平台功能

- 会员管理 100%
- 商城管理 10%
- 商品管理 0%
- 推广管理 0%
- 系统管理 0%

#### 开发计划

。。。