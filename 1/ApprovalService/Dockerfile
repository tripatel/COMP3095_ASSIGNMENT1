# Start with an official OpenJDK image as the base image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the build artifact (JAR file) from the host to the container
COPY build/libs/ApprovalService-0.0.1-SNAPSHOT.jar app.jar



# Expose the port on which the service runs (port 6001 as per application.properties)
EXPOSE 6001

# Set the environment variables for MongoDB connection (MongoDB service name is 'mongo')
ENV SPRING_DATA_MONGODB_HOST=mongo
ENV SPRING_DATA_MONGODB_PORT=27017
ENV SPRING_DATA_MONGODB_DATABASE=approval-service
ENV SPRING_DATA_MONGODB_USERNAME=admin
ENV SPRING_DATA_MONGODB_PASSWORD=password

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
