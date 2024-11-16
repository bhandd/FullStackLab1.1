package com.example.FullStackLab11.dao;

import com.example.FullStackLab11.model.JournalEntry;
import com.example.FullStackLab11.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageDAO {
    public static Message FromDBtoBO(MessageDB messageDB) {
        return new Message(
                messageDB.getSenderId(),
                messageDB.getRecieverId(),
                messageDB.getMessage());
    }

    public static List<Message> FromDBtoBO(List<MessageDB> messageDB) {
        List<Message> newMessages = new ArrayList<>();
        for (MessageDB message : messageDB) {
            newMessages.add(FromDBtoBO(message));
        }
        return newMessages;
    }

    public static MessageDB FromBOtoDB(Message message) {
        return new MessageDB(
                message.getSenderId(),
                message.getRecieverId(),
                message.getMessage());
    }

    public static List<MessageDB> FromBOtoDB(List<Message> messages) {
        List<MessageDB> newMessages = new ArrayList<>();
        for (Message message : messages) {
            newMessages.add(FromBOtoDB(message));
        }
        return newMessages;
    }
}
