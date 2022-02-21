FROM amazoncorretto:11-alpine-jdk

#RUN apk add tcpdump
#RUN apk add net-tools
#RUN apk add iputils

ARG JAR_FILE=target/*.jar
ARG APP_DIR=/opt/app
COPY ${JAR_FILE} ${APP_DIR}/application.jar
WORKDIR ${APP_DIR}

ENTRYPOINT ["java", "-jar", "application.jar"]