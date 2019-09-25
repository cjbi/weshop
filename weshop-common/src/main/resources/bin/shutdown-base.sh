# 注册中心jar包名称
export eureka_server_jar_name=weshop-eureka-server-@project.version@.jar
# 配置中心jar包名称
export config_server_jar_name=weshop-config-server-@project.version@.jar
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
