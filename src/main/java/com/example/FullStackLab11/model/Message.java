package com.example.FullStackLab11.model;

public class Message {
    private long senderId;
    private long recieverId;
    private String message;

    public Message(long senderId, long recieverId, String message) {
        this.senderId = senderId;
        this.recieverId = recieverId;
        this.message = message;
    }

    public Message() {

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
