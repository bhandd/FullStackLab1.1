package com.example.FullStackLab11.model;

public class Message {
    private long id;
    private long senderId;
    private long recieverId;
    private String message;

    public Message(long id, long senderId, long recieverId, String message) {
        this.id = id;
        this.senderId = senderId;
        this.recieverId = recieverId;
        this.message = message;
    }

    public Message() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public long getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(long recieverId) {
        this.recieverId = recieverId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
