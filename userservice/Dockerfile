FROM openjdk:11
EXPOSE 8081
COPY target/userservice-1.0.jar userservice-1.0.jar
ARG JAR_FILE=target/userservice-1.0.jar
ADD ${JAR_FILE} userservice-1.0.jar
ENTRYPOINT ["java","-jar","/userservice-1.0.jar"]