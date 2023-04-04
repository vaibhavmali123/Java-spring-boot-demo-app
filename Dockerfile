FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.war demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/demo-0.0.1-SNAPSHOT.jar"] 
EXPOSE 8080