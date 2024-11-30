# Step 1: Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim
LABEL authors="jhjoo"

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the JAR file into the container
COPY build/libs/TrafficServer-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port your app runs on
EXPOSE 8080

# Step 5: Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]