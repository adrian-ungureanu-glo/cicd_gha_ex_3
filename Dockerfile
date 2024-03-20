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

# Set the profile to the value of an existing environment variable
ENV SPRING_PROFILES_ACTIVE=$APP_ENV_NAME

# Expose the port
EXPOSE 8080

# Start the Spring Boot application
CMD ["java", "-jar", "app.jar"]