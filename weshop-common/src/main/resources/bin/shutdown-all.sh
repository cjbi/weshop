#!/bin/sh

# jar包名称

# 注册中心jar包名称
export eureka_server_jar_name=weshop-eureka-server-@project.version@.jar
# 配置中心jar包名称
export config_server_jar_name=weshop-config-server-@project.version@.jar
# 用户中心jar包名称
export user_jar_name=weshop-user-@project.version@.jar
# 商品中心jar包名称
export goods_jar_name=weshop-goods-@project.version@.jar
# 订单中心jar包名称
export order_jar_name=weshop-order-@project.version@.jar
# 支付中心jar包名称
export pay_jar_name=weshop-pay-@project.version@.jar
# 微信端服务jar包名称
export wechat_jar_name=weshop-wechat-@project.version@.jar
# 网关服务jar包名称
export api_gateway_jar_name=weshop-api-gateway-1.0.0-SNAPSHOT.jar

# 以下服务还未开发完成，暂时不启动
# export storage_jar_name=weshop-storage-@project.version@.jar
# export admin_jar_name=weshop-admin-@project.version@.jar

# 根据启动的jar包名称关闭旧的进程实例
# 关闭注册中心服务
eureka_server_pid=`ps -ef | grep $eureka_server_jar_name | grep -v grep | awk '{print $2}'`
if [ -n "$eureka_server_pid" ]
then
  echo "关闭注册中心服务旧进程：$eureka_server_pid"
  kill -9 $eureka_server_pid
fi
# 关闭配置中心服务
config_server_pid=`ps -ef | grep $config_server_jar_name | grep -v grep | awk '{print $2}'`
if [ -n "$config_server_pid" ]
then
  echo "关闭配置中心服务旧进程：$config_server_pid"
  kill -9 $config_server_pid
fi
# 关闭用户中心服务
user_pid=`ps -ef | grep $user_jar_name | grep -v grep | awk '{print $2}'`
if [ -n "$user_pid" ]
then
  echo "关闭用户中心服务旧进程：$user_pid"
  kill -9 $user_pid
fi
# 关闭商品中心服务
goods_pid=`ps -ef | grep $goods_jar_name | grep -v grep | awk '{print $2}'`
if [ -n "$goods_pid" ]
then
  echo "关闭商品中心服务旧进程：$goods_pid"
  kill -9 $goods_pid
fi
# 关闭订单中心服务
order_pid=`ps -ef | grep $order_jar_name | grep -v grep | awk '{print $2}'`
if [ -n "$order_pid" ]
then
  echo "关闭订单中心服务旧进程：$order_pid"
  kill -9 $order_pid
fi
# 关闭支付中心服务
pay_pid=`ps -ef | grep $pay_jar_name | grep -v grep | awk '{print $2}'`
if [ -n "$pay_pid" ]
then
  echo "关闭支付中心服务旧进程：$pay_pid"
  kill -9 $pay_pid
fi
# 关闭微信端服务
wechat_pid=`ps -ef | grep $wechat_jar_name | grep -v grep | awk '{print $2}'`
if [ -n "$wechat_pid" ]
then
  echo "关闭微信端服务旧进程：$wechat_pid"
  kill -9 $wechat_pid
fi
# 关闭网关服务
api_gateway_pid=`ps -ef | grep $api_gateway_jar_name | grep -v grep | awk '{print $2}'`
if [ -n "$api_gateway_pid" ]
then
  echo "关闭网关服务服务旧进程：$api_gateway_pid"
  kill -9 $api_gateway_pid
fi
