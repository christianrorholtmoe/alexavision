FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
COPY target/backend-1.0.jar appl.jar
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar /appl.jar