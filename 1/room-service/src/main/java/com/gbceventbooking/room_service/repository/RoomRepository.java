package com.gbceventbooking.room_service.repository;

import com.gbceventbooking.room_service.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {
}
