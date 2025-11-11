# Use official Java 21 image
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/salesapp.jar /app/salesapp.jar

# Expose the port your app listens on (if needed)
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "/app/salesapp.jar"]
