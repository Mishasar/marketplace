FROM openjdk:11-jre-slim

COPY ./app/build/libs/app-0.0.1.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]
