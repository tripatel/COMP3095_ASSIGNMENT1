Here's a guide for writing a README that effectively explains how your Room Booking and Event Management System project works. This README covers setup instructions, an overview of the project architecture, and usage details to help others understand and run your project.

---

## Room Booking and Event Management System

This project is a microservices-based application for managing room bookings and events. Built with **Spring Boot**, **MongoDB**, **Docker**, and **Postman** for testing, it offers services for users, rooms, approvals, bookings, and events. Each service runs independently, enabling a scalable and modular application.

### Table of Contents

1. [Project Overview](#project-overview)
2. [Tech Stack](#tech-stack)
3. [Architecture](#architecture)
4. [Installation and Setup](#installation-and-setup)
5. [Usage](#usage)
6. [Services and Endpoints](#services-and-endpoints)
7. [Troubleshooting](#troubleshooting)

---

### 1. Project Overview

This application is designed for managing room bookings, event approvals, and user registrations. Each function is encapsulated in a dedicated microservice:
- **User Service**: Handles user data and authentication.
- **Room Service**: Manages room information and availability.
- **Approval Service**: Approves or rejects booking requests.
- **Booking Service**: Facilitates room booking management.
- **Event Service**: Manages events and event-related details.

### 2. Tech Stack

- **Java (Spring Boot)**: Framework for building each microservice.
- **MongoDB**: NoSQL database to store user, room, booking, and event data.
- **Docker**: Containerizes each service, ensuring consistency and easy deployment.
- **Postman**: Used for API testing and validation.

### 3. Architecture

The application follows a **microservices architecture**:
- Each microservice is independently developed, maintained, and deployed.
- All services are containerized and managed via **Docker Compose**.
- **MongoDB** serves as the primary database, shared across all services.

### 4. Installation and Setup

To run this project locally, make sure you have **Docker** and **Docker Compose** installed.

#### Steps:

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd room-booking-event-management
   ```

2. **Run Docker Compose**:
   Launch all services using Docker Compose.
   ```bash
   docker-compose up -d
   ```
   This command will:
   - Build and start each microservice container.
   - Start MongoDB as the central database.
   - Expose each service on `localhost` ports: `6003` (Room), `6004` (User), `6001` (Approval), `8095` (Booking), `6006` (Event).

3. **Verify Services**:
   Run `docker ps` to confirm that all containers are running. If you need to stop the services, run:
   ```bash
   docker-compose down
   ```

### 5. Usage

You can test the functionality of each service using **Postman**.

1. **Import Postman Collection**:
   Import the provided Postman collection (`postman_collection.json`) to simplify testing each endpoint.

2. **Access Each Service**:
   - **User Service**: http://localhost:6004
   - **Room Service**: http://localhost:6003
   - **Approval Service**: http://localhost:6001
   - **Booking Service**: http://localhost:8095
   - **Event Service**: http://localhost:6007

### 6. Services and Endpoints

Below is a summary of each service’s primary endpoints. 

#### User Service (`http://localhost:6004`)

- **POST /users**: Create a new user.
  - **Body**: `{ "username": "string", "password": "string" }`
- **GET /users/{id}**: Retrieve user details by ID.

#### Room Service (`http://localhost:6003`)

- **POST /rooms**: Add a new room.
  - **Body**: `{ "roomName": "string", "capacity": "integer" }`
- **GET /rooms/{id}**: Retrieve room details by ID.

#### Approval Service (`http://localhost:6005`)

- **POST /approvals**: Approve or reject booking requests.
  - **Body**: `{ "bookingId": "string", "status": "approved/rejected" }`
  
#### Booking Service (`http://localhost:6006`)

- **POST /bookings**: Create a booking request.
  - **Body**: `{ "userId": "string", "roomId": "string", "date": "string" }`
- **GET /bookings/{id}**: Retrieve booking details by ID.

#### Event Service (`http://localhost:6007`)

- **POST /events**: Create a new event.
  - **Body**: `{ "eventName": "string", "description": "string", "date": "string" }`
- **GET /events/{id}**: Retrieve event details by ID.

### 7. Troubleshooting

If you encounter issues, here are some potential solutions:

1. **Services Not Accessible in Postman**:
   - Ensure all services are up by running `docker ps`.
   - Double-check port mappings in `docker-compose.yml` and Postman.

2. **MongoDB Connection Issues**:
   - Verify MongoDB settings in `application.properties` for each service.
   - Ensure `MONGO_INITDB_ROOT_USERNAME` and `MONGO_INITDB_ROOT_PASSWORD` match those in the Docker Compose file.

3. **Network Configuration**:
   - All services should be on the same Docker network (`app-network`). If a service cannot connect, restart Docker Compose with `docker-compose down` and `docker-compose up`.

4. **Resource Cleanup**:
   - If Docker containers consume too much memory or get stuck, use `docker-compose down -v` to remove volumes and restart.

### Conclusion

This project demonstrates a microservices-based Room Booking and Event Management System using Spring Boot, MongoDB, and Docker. Each service is designed to operate independently, allowing for modular and scalable growth.

Feel free to reach out with any questions or feedback. Happy coding!

--- 

This README provides clear instructions on setup, usage, and troubleshooting, making it easier for others to understand and work with your project. Let me know if you’d like further customization!
