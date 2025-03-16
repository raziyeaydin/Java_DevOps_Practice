# Which JDK you use for your application to run
FROM amazoncorretto:17
#FROM openjdk:17

# Which directory your jar file of your project is inside
ARG JAR_FILE=target/*.jar

# To create or copy your jar file to Docker with this name(you should use lower letter)
COPY ${JAR_FILE} app.jar

# To indicate the internal port
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]