# 基础镜像
FROM openjdk:8-jdk-alpine

# 设置工作目录
WORKDIR /app/weblog

# 设置时区
ENV TZ=Asia/Shanghai

# 设置 JAVA_OPTS 环境变量
ENV JAVA_OPTS="-Xms300m -Xmx300m -Djava.security.egd=file:/dev/./urandom"

# 应用参数
ENV ARGS=""

# 暴露 8080 端口
EXPOSE 8080

# 启动命令
CMD ["sh", "-c", "java ${JAVA_OPTS} -jar weblog-web-0.0.1-SNAPSHOT.jar $ARGS"]
