FROM openjdk:17-jdk-alpine
VOLUME /temp
ADD target/Project-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]