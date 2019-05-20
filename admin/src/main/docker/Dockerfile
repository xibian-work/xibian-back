FROM tomcat:8.5-jre8-alpine
# 维护者
MAINTAINER "chenwt <feiniaoying@163.com>"

# 设置时区为东八区，并清除tomcat工作目录
# ADD /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN echo 'Asia/Shanghai' >/etc/timezone \
&& rm -rf /usr/local/tomcat/webapps/

# com.spotify插件中JAR_FILE传值
ARG JAR_FILE
# 复制war到镜像
ADD ${JAR_FILE} /usr/local/tomcat/webapps/ROOT.war

# 切换工作目录
WORKDIR /usr/local/tomcat/webapps/

#启动tomcat shell执行程序
CMD ["catalina.sh", "run"]
EXPOSE 8080