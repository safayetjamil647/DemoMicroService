FROM amazoncorretto:11-alpine-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} CurrencyExchangeService-0.0.1-SNAPSHOT.jar
RUN apk add tcpdump
RUN apk add net-tools
RUN apk add iputils

ENTRYPOINT ["java","-jar","/CurrencyExchangeService-0.0.1-SNAPSHOT.jar"]

#docker build --tag=currency-exchange:latest .
#
##docker run -p 8100:8100 currency-exchange:latest