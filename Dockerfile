FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.war demo-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-war","/demo-0.0.1-SNAPSHOT.war"] 
EXPOSE 8080