FROM openjdk:11
EXPOSE 8082
COPY target/favouriteservice-1.0.jar favouriteservice-1.0.jar
ARG JAR_FILE=target/favouriteservice-1.0.jar
ADD ${JAR_FILE} favouriteservice-1.0.jar
ENTRYPOINT ["java","-jar","/favouriteservice-1.0.jar"]