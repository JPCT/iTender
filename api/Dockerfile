FROM maven:3.8.6-openjdk-8-slim AS build
COPY src .
COPY pom.xml .
RUN mvn -f clean package

FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} villa-amelia-app-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/villa-amelia-app-0.0.1-SNAPSHOT.jar"]