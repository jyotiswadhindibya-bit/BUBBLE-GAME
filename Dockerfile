# 1. Build Stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
# Build the app (skipping tests to save time/memory)
RUN mvn clean package -DskipTests

# 2. Run Stage
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
# Copy the built jar file from the build stage
COPY --from=build /app/target/*.jar app.jar
# Expose port 8080 (standard for Spring Boot)
EXPOSE 8080
# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]