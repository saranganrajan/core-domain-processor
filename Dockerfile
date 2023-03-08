FROM adoptopenjdk/openjdk11:alpine-jre
MAINTAINER apps.saranganrajan.com
COPY target/core-domain-processor-0.0.1-SNAPSHOT.jar core-domain-processor.jar
ENTRYPOINT ["java","-jar","/core-domain-processor.jar"]