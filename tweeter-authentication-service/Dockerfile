
# # Use an official OpenJDK image as the base image
# FROM openjdk:17-jdk-slim

# # Install Maven (or Gradle) to build the project
# RUN apt-get update && apt-get install -y maven

# # Set the working directory in the container
# WORKDIR /app

# # Copy the pom.xml (or build.gradle) and src directory for Maven (or Gradle) build
# COPY pom.xml .
# COPY src ./src

# # Build the application using Maven (or Gradle)
# RUN mvn clean install -DskipTests

# # Expose the port the app will run on
# EXPOSE 8080


# # Run the application
# ENTRYPOINT ["java", "-jar", "target/tweeter-authentication-service-0.0.1-SNAPSHOT.jar"]








#
# # Use an official OpenJDK image as the base image
# FROM openjdk:17-jdk-slim
#
# # Install Maven to build the project
# RUN apt-get update && apt-get install -y maven
#
# # Set the working directory in the container
# WORKDIR /app
#
# # Copy the pom.xml (or build.gradle) first to leverage Docker cache
# COPY pom.xml .
#
# # Download dependencies without copying the whole source code
# RUN mvn dependency:go-offline
#
# # Copy the source code
# COPY src ./src
#
# # Build the application using Maven
# RUN mvn clean install -DskipTests
#
# # Expose the port the app will run on
# EXPOSE 8080
#
# # Run the application
# ENTRYPOINT ["java", "-jar", "target/tweeter-authentication-service-0.0.1-SNAPSHOT.jar"]

# Stage 1: Build Stage
FROM maven:3.8-jdk-17 as build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml first to leverage Docker cache for dependencies
COPY pom.xml .

# Download dependencies without copying the whole source code
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the application using Maven (including tests)
RUN mvn clean install -DskipTests

# Stage 2: Runtime Stage (Slim runtime image)
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file from the build stage
COPY --from=build /app/target/tweeter-authentication-service-0.0.1-SNAPSHOT.jar ./tweeter-authentication-service.jar

# Expose the port the app will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "tweeter-authentication-service.jar"]
