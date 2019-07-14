FROM adoptopenjdk/openjdk11
MAINTAINER ola@lovholm.net
VOLUME /tmp
ARG JAR_FILE=server/target/application.jar
COPY ${JAR_FILE} app.jar
ADD server/*.properties ./
EXPOSE 8080 80
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
