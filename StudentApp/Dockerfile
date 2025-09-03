# Use official OpenJDK image
FROM openjdk:17

# Set working directory
WORKDIR /app

# Copy only necessary files
COPY . .

# Build the application
RUN ./gradlew build

# Expose port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app/build/libs/StudentApp.jar"]