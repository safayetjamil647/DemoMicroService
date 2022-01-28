FROM amazoncorretto:11-alpine-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} GeoLocationService-0.0.1-SNAPSHOT.jar
RUN apk add tcpdump
RUN apk add net-tools
RUN apk add iputils

ENTRYPOINT ["java","-jar","/GeoLocationService-0.0.1-SNAPSHOT.jar"]

#docker build --tag=geo-service:latest .
#
##docker run -p 8200:8200 geo-service:latest
