FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
#COPY target/backend-1.0.jar app.jar
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar /backend-1.0.jar
#RUN java backend-1.0.jar