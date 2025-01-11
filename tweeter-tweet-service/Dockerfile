#
## Use an official OpenJDK image as the base image
#FROM openjdk:17-jdk-slim
#
## Install Maven (or Gradle) to build the project
#RUN apt-get update && apt-get install -y maven
#
## Set the working directory in the container
#WORKDIR /app
#
## Copy the pom.xml (or build.gradle) and src directory for Maven (or Gradle) build
#COPY pom.xml .
#COPY src ./src
#
## Build the application using Maven (or Gradle)
#RUN mvn clean install -DskipTests
#
## Expose the port the app will run on
#EXPOSE 8080
#
## Run the application
#ENTRYPOINT ["java", "-jar", "target/tweeter-tweet-service-0.0.1-SNAPSHOT.jar"]
#
#


# Use an official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Install Maven to build the project
RUN apt-get update && apt-get install -y maven

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml (or build.gradle) first to leverage Docker cache
COPY pom.xml .

# Download dependencies without copying the whole source code
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the application using Maven
RUN mvn clean install -DskipTests

# Expose the port the app will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "target/tweeter-tweet-service-0.0.1-SNAPSHOT.jar"]
