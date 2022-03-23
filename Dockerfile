#FROM maven:3.8.4-jdk-11
####
###ADD target/*.jar app.jar
###ENTRYPOINT ["java","-jar","app.jar"]
##
##
##
###
###
#WORKDIR /airport
#COPY . /airport
#RUN mvn clean install
#EXPOSE 8080
#
#CMD mvn spring-boot:run
###



#
#FROM maven:3.8.4-jdk-11-slim
#ADD target/airportRestfulApi-0.0.1-SNAPSHOT.jar airportRestfulApi-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/airportRestfulApi-0.0.1-SNAPSHOT.jar"]

#
FROM maven:3.8.4-jdk-11-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]