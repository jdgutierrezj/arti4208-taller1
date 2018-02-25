FROM openjdk:8-jdk-alpine
# Required for starting application up.
RUN apk update && apk add bash

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app

COPY target/mail-service-1.0.0.jar $PROJECT_HOME/mail-service-1.0.0.jar

WORKDIR $PROJECT_HOME

CMD ["java", "-Dspring.data.mongodb.uri=mongodb://mail-service-db:27017/matidb","-Djava.security.egd=file:/dev/./urandom","-jar","./mail-service-1.0.0.jar"]