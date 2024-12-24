
# Use a smaller base image for running the application
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY /target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]