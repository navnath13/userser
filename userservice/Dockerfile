# Use OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the Spring Boot JAR into the container
COPY target/userservice-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 9191

# Run the app
ENTRYPOINT ["java","-jar","app.jar"]
