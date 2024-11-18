package com.example.FullStackLab11.controller;

import com.example.FullStackLab11.Services.MessageService;
import com.example.FullStackLab11.dao.MessageDAO;
import com.example.FullStackLab11.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MessageController {

    private List<Message> messages = new ArrayList<>();

    @Autowired
    private MessageService messageService;

    // GET all messages
    @RequestMapping(value = "/messages", method = RequestMethod.GET,
            produces = "application/json")
    public List<Message> getAllMessages() {
        return messages = MessageDAO.FromDBtoBO(messageService.getAllMessages());
    }
    // GET a message
    @RequestMapping(value = "/messages/{id}", method = RequestMethod.GET,
            produces = "application/json")
    public Message getMessageById(@PathVariable("id") long id) {
        return MessageDAO.FromDBtoBO(messageService.getMessageById(id));
    }
    // GET messages by sender ID
    @RequestMapping(value = "/messages/s{id}", method = RequestMethod.GET,
            produces = "application/json")
    public List<Message> findAllMessagesBySenderId(@PathVariable("id") long id) {
        return MessageDAO.FromDBtoBO(messageService.findAllMessagesBySenderId(id));
    }
    // GET messages by reciever ID
    @RequestMapping(value = "/messages/r{id}", method = RequestMethod.GET,
            produces = "application/json")
    public List<Message> findAllMessagesByRecieverId(@PathVariable("id") long id) {
        return MessageDAO.FromDBtoBO(messageService.findAllMessagesByRecieverId(id));
    }

    // POST
    @RequestMapping(value = "/messages", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Message> createMessage(@RequestBody Message newMessage) {
        messageService.saveMessage(MessageDAO.FromBOtoDB(newMessage));
        return ResponseEntity.status(HttpStatus.CREATED).body(newMessage);
    }

    /*return messages.stream()
            .filter(message -> message.getId() == id)
            .collect(Collectors.toList());

    return messages.stream()
            .filter(message -> message.getId() == id)
            .findFirst()
            .orElse(null);*/
}
