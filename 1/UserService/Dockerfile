FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the build artifact (JAR file) from the host to the container
COPY build/libs/UserService-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the service runs
EXPOSE 6004

# Set environment variables for MongoDB connection (adjust as needed)
ENV SPRING_DATA_MONGODB_HOST=mongo2
ENV SPRING_DATA_MONGODB_PORT=27017
ENV SPRING_DATA_MONGODB_DATABASE=user-db
ENV SPRING_DATA_MONGODB_USERNAME=admin
ENV SPRING_DATA_MONGODB_PASSWORD=password

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
