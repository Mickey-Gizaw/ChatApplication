package com.doodle.backend.controller;

import com.doodle.backend.model.Message;
import com.doodle.backend.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class ChatController {

    public static final String ROOM_ID = "RoomId";

    private final UserService userService;

    private final RoomService roomService;

    private final MessageService messageService;

    public ChatController(UserService userService, RoomService roomService, MessageService messageService ) {
        this.userService = userService;
        this.roomService = roomService;
        this.messageService = messageService;
    }

    @PostMapping("/createUser/{userName}")
    ResponseEntity<String> createUser(@PathVariable String userName) {

        String createdUser = userService.createUser(userName);

        if (createdUser.equals("Invalid_Username")) {
            return new ResponseEntity<>(createdUser,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @PostMapping("/createRoom/{roomName}")
    ResponseEntity<String> createRoom(@PathVariable String roomName) {

        String createdRoom = roomService.createRoom(roomName);

        if (createdRoom.equals("Invalid_RoomName")) {
            return new ResponseEntity<>(createdRoom,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(createdRoom, HttpStatus.OK);
    }


    @GetMapping("/rooms/{roomName}")
    ResponseEntity<List<Message>> getMessages(@PathVariable String roomName) {

        List<Message> messages = messageService.fetchMessages(roomName);

        return new ResponseEntity<>(messages,HttpStatus.OK);
    }


    @PostMapping("/rooms/message")
    ResponseEntity<Message> postMessage(@RequestBody Message message) {
        Message postedMessage = messageService.postMessage(message.roomName, message.userName, message.message);
        return new ResponseEntity<>(postedMessage, HttpStatus.OK);
    }
}






