# Use official Maven image to build the app
FROM maven:3.9.6-openjdk-17 AS build

WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use OpenJDK image for running the app
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy built jar from the build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
