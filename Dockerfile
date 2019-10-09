#从基础镜像开始构建
FROM registry.cn-shanghai.aliyuncs.com/quanwai_base/base:java8runtimeV2
#设置环境变量
# ENV JAVA_OPTS="$JAVA_OPTS -Xms256M -Xmx512M -XX:+AggressiveOpts -XX:+UseBiasedLocking -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:+CMSParallelRemarkEnabled -XX:LargePageSizeInBytes=128m -XX:+UseCMSInitiatingOccupancyOnly -Djava.awt.headless=true -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -Xloggc:/data/applogs/kotler_gc.log -Djdk.tls.ephemeralDHKeySize=2048 -Djava.security.egd=file:/dev/./urandom"
#将运行包复制到容器中
ADD target/hresource-1.0.jar /app/hresource-1.0.jar
#允许外界访问容器的8081端口
EXPOSE 8080
#容器健康检查

#启动命令
CMD java -jar /app/hresource-1.0.jar --server.port=8080