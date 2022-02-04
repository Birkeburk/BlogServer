FROM openjdk:17

COPY out/artifacts/ServerBlog_jar/ServerBlog.jar /opt/ServerBlog.jar

WORKDIR /opt

CMD java -jar ServerBlog.jar
