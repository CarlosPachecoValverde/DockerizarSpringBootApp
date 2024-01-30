FROM openjdk:17-jdk-alpine
WORKDIR /app
EXPOSE 8080
COPY build/libs/Proyectousuarios-0.0.1-SNAPSHOT.jar /app/Proyectousuarios-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "Proyectousuarios-0.0.1-SNAPSHOT.jar"]
LABEL version="1.0"
