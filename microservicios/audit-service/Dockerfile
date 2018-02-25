FROM openjdk:8-jdk-alpine
# Required for starting application up.
RUN apk update && apk add bash

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app

COPY target/audit-service-1.0.0.jar $PROJECT_HOME/audit-service-1.0.0.jar

WORKDIR $PROJECT_HOME

CMD ["java", "-Dspring.data.mongodb.uri=mongodb://audit-service-db:27017/matidb","-Djava.security.egd=file:/dev/./urandom","-jar","./audit-service-1.0.0.jar"]