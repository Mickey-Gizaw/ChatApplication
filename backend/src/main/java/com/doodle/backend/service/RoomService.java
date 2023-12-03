package com.doodle.backend.service;

import com.doodle.backend.model.Room;
import com.doodle.backend.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public String createRoom(String roomName) {

        Room room = roomRepository.findByRoomName(roomName);

        if (room != null) {
            return "Invalid_RoomName";
        }
        Room newRoom = new Room(roomName);

        roomRepository.save(newRoom);
        return newRoom.getRoomName();
    }
}
