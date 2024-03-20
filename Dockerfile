# Use Maven image as base image
FROM maven:3-eclipse-temurin-21 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml file
COPY add-sample-api/pom.xml .

# Download the dependencies
RUN mvn dependency:go-offline -B

# Copy the source code
COPY add-sample-api/src ./src

# Build the application
RUN mvn package -DskipTests

# Use OpenJDK image as base image
FROM eclipse-temurin:21

# Set the working directory
WORKDIR /app

# Copy the .jar artifact from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port
EXPOSE 8080

# Set the entrypoint with VM arguments to set the Spring active profile
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=$APP_ENV_NAME", "app.jar"]


