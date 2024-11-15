package com.example.FullStackLab11.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class JournalEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "patient_id", nullable = false)
    private int patientId;
    @Column(name = "entry", nullable = false)
    private String entry;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "condition")
    private Condition condition;
    @OneToOne
    private Journal journal;

    public JournalEntry(int id, int patientId, int personnelId, String entry, Date startDate, Date endDate, Condition condition) {
        this.id = id;
        this.patientId = patientId;
        this.entry = entry;
        this.startDate = startDate ;
        this.endDate = endDate;
        this.condition = condition;

    }

    public JournalEntry() {
    }

    public long getId() {
        return id;
    }

    public long getPatientId() {
        return patientId;
    }


    public String getEntry() {
        return entry;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "JournalEntry{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", entry='" + entry + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }


}
