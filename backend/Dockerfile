FROM openjdk:14-ea-14-slim-buster

ARG JAR_FILE=target/backend-service-0.0.1.jar

WORKDIR /opt/app

COPY ${JAR_FILE} app.jar

EXPOSE 8080

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]