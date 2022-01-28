FROM amazoncorretto:11-alpine-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ApiGateway-0.0.1-SNAPSHOT.jar
RUN apk add tcpdump
RUN apk add net-tools
RUN apk add iputils

ENTRYPOINT ["java","-jar","/ApiGateway-0.0.1-SNAPSHOT.jar"]
#docker build --tag=api-gateway:latest .
#
##docker run -p 8765:8765 api-gateway:latest