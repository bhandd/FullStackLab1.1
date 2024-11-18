package com.example.FullStackLab11.Services;

import com.example.FullStackLab11.Repositories.MessageRepository;
import com.example.FullStackLab11.dao.MessageDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    // POST
    public MessageDB saveMessage(MessageDB message) {
        return messageRepository.save(message);
    }

    // READ
    public List<MessageDB> getAllMessages() {
        return (List<MessageDB>) messageRepository.findAll();
    }
    public MessageDB getMessageById(long id) {
        return messageRepository.findById(id).orElse(null);
    }

    // READ
    public List<MessageDB> findAllMessagesBySenderId(Long id) {
        return messageRepository.findAllBySenderId(id);
    }

    // READ
    public List<MessageDB> findAllMessagesByRecieverId(Long id) {
        return messageRepository.findAllByRecieverId(id);
    }
}
