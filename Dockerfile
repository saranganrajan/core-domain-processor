FROM openjdk:8-jdk-alpine
MAINTAINER apps.saranganrajan.com
COPY target/core-domain-processor-0.0.1-SNAPSHOT.jar core-domain-processor-0.0.1.jar
ENTRYPOINT ["java","-jar","/core-domain-processor-0.0.1.jar"]