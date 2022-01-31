FROM amazoncorretto:11-alpine-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} NamingServer-0.0.1-SNAPSHOT.jar

#RUN apk add tcpdump
#RUN apk add net-tools
#RUN apk add iputils

ENTRYPOINT ["java","-jar","/NamingServer-0.0.1-SNAPSHOT.jar"]