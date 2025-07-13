# Use official Java 21 JDK base image
FROM eclipse-temurin:21-jdk-jammy

# Set working directory inside container
WORKDIR /app

# Copy built jar file (make sure to build first with mvn clean package)
COPY target/eureka-server-0.0.1-SNAPSHOT.jar app.jar

# Expose port (change to your service's port)
EXPOSE 8761

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]