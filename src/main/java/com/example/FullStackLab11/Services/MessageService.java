package com.example.FullStackLab11.Services;

import com.example.FullStackLab11.Repositories.MessageRepository;
import com.example.FullStackLab11.dao.MessageDB;
import com.example.FullStackLab11.dao.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    // Create
    public MessageDB saveMessage(MessageDB message) {
        return messageRepository.save(message);
    }

    // Read
    public List<MessageDB> getAllMessages() {
        return (List<MessageDB>) messageRepository.findAll();
    }

    public List<MessageDB> findAllBySenderId(Long id) {
        return messageRepository.findAllBySenderId(id);
    }

    public List<MessageDB> findAllByReceiverId(Long id) {
        return messageRepository.findAllByReceiverId(id);
    }
}
