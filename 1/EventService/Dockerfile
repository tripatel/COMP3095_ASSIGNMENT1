# Start with an official OpenJDK image as the base image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the build artifact (JAR file) from the host to the container
# Make sure the path here matches the actual location of the JAR file
COPY build/libs/EventService-0.0.1-SNAPSHOT-plain.jar app.jar

# Expose the port on which the service runs (port 6006 as per application.properties)
EXPOSE 6006

# Set the environment variables for MongoDB connection (MongoDB service name is 'mongo')
ENV SPRING_DATA_MONGODB_HOST=mongo
ENV SPRING_DATA_MONGODB_PORT=27017
ENV SPRING_DATA_MONGODB_DATABASE=event-service
ENV SPRING_DATA_MONGODB_USERNAME=admin
ENV SPRING_DATA_MONGODB_PASSWORD=password

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

# Optionally, you could specify a default command to run if ENTRYPOINT is not enough
# CMD ["java", "-jar", "app.jar"]
