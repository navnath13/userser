# Stage 1: Build
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create a custom image that includes MySQL
FROM openjdk:17.0.1-jdk-slim

# Install MySQL
RUN apt-get update && \
    apt-get install -y mysql-server && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Copy the application JAR file from the build stage
COPY --from=build /target/demo.jar demo.jar

# MySQL configuration
ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=mydb
ENV MYSQL_USER=user
ENV MYSQL_PASSWORD=password

# Expose MySQL port
EXPOSE 3306

# Expose application port
EXPOSE 8080

# Start MySQL and the application
CMD service mysql start && java -jar demo.jar