FROM eclipse-temurin:17-jre-alpine as builder
WORKDIR /app
COPY target/FullStackLab1.1-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]