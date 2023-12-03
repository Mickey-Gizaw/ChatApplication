package com.doodle.backend.repository;

import com.doodle.backend.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {

    Room findByRoomName(String roomName);

}
