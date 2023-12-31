package com.doodle.backend.service;

import com.doodle.backend.model.Message;
import com.doodle.backend.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> fetchMessages(String roomName) {
        return messageRepository.findAllByRoomNameOrderByDateAsc(roomName);
    }

    public Message postMessage(String roomName, String userName, String message) {

        Message postMessage = new Message(roomName, userName, message);
        postMessage.setDate(new Date());

        return messageRepository.save(postMessage);
    }
}
