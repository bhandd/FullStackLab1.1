package com.example.FullStackLab11.dao;

import jakarta.persistence.*;

@Entity
public class MessageDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "patientId")
    private long senderId;
    @Column(name = "staffId")
    private long recieverId;
    @Column(name = "message")
    private String message;

    public MessageDB(long senderId, long recieverId, String message) {
        this.senderId = senderId;
        this.recieverId = recieverId;
        this.message = message;
    }

    public MessageDB() {

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
