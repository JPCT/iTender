FROM maven:3.8.6-openjdk-8-slim AS build
COPY . .
RUN mvn clean package

FROM openjdk:8-jdk-alpine
COPY --from=build /target/*.jar iTender-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/iTender-0.0.1-SNAPSHOT.jar"]