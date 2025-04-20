# Multi-stage build for Spring Boot application

# Build stage
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copy gradle configuration files
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY core core
COPY storage storage

# Make gradlew executable
RUN chmod +x ./gradlew

# Build the application
RUN ./gradlew :core:core-api:bootJar --info

# Runtime stage
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy the built jar file from the build stage
COPY --from=build /app/core/core-api/build/libs/*.jar app.jar

# Set Spring profile to prod
ENV SPRING_PROFILES_ACTIVE=prod

# Port that the application will listen on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]