package com.example.FullStackLab11.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Journal {

    private long patientId;

    @OneToMany
    private List<JournalEntry> entries;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    public Journal(int patientId) {
        this.patientId = patientId;
        this.entries = new ArrayList<>();
    }

    public Journal() {
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public List<JournalEntry> getEntries() {
        //todo: return a copy of the list
        return entries;
    }

    public void addEntry(JournalEntry entry) {
        entries.add(entry);
    }

    public JournalEntry getEntry(long id) {
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
