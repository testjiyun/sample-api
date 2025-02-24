FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar

EXPOSE 3389

ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
