FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER gavinlen gavin_len@163.com
VOLUME /opt/docker
ADD big-data-docker-build.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/opt/urandom -jar /app.jar" ]