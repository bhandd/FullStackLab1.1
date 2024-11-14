package com.example.FullStackLab11.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Journal {

    private int patientId;

    private List<JournalEntry> entries;
    @Id
    private Long id;


    public Journal(int patientId) {
        this.patientId = patientId;
        this.entries = new ArrayList<>();
    }

    public Journal() {
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public List<JournalEntry> getEntries() {
        //todo: return a copy of the list
        return entries;
    }

    public void addEntry(JournalEntry entry) {
        entries.add(entry);
    }

    public JournalEntry getEntry(int id) {
        for (JournalEntry entry : entries) {
            if (entry.getId() == id) {
                return entry;
            }
        }
        return null;
    }

    public void setEntries(List<JournalEntry> entries) {
        this.entries = entries;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
