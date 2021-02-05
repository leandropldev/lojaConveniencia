FROM maven:3.6.1-jdk-11-slim AS build  
COPY app-loja ./   
RUN mvn clean package

FROM openjdk:11-jdk-slim
VOLUME /tpm
COPY --from=build /target/app-loja-0.0.1-SNAPSHOT.jar app.jar
#ADD  app-loja/target/app-loja-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar" ]


#FROM maven:3.5-jdk-8 AS build  
#COPY src /usr/src/app/src  
#COPY pom.xml /usr/src/app  
#RUN mvn -f /usr/src/app/pom.xml clean package

#FROM gcr.io/distroless/java  
#COPY --from=build /usr/src/app/target/itau-file-manager.jar /usr/app/itau-file-manager.jar 
#EXPOSE 8080  
#ENTRYPOINT ["java","-jar","/usr/app/itau-file-manager.jar"]