package com.example.FullStackLab11.model;
public class Patient {

    private long id;
    private String name;
    private Journal journal;


    public Patient(long id, String name, Journal journal) {
        this.id = id;
        this.name = name;
        this.journal = journal;
    }

    public Patient(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}