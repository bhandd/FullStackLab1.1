package com.example.FullStackLab11.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Patient {

    @Id
    private long id;
    private String name;

    private Journal journal;


    public Patient(long id, String name, Journal journal) {

        this.id = id;
        this.name = name;
        this.journal = journal;
    }

    public Patient(){
        this.journal = new Journal();

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

    public Journal getJournal() {
     //   return journal;
        return null;
    }

    public void updateJournal(Journal journal) {
        this.journal = journal;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}