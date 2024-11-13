package com.example.FullStackLab11.model;

import java.util.Date;

public class JournalEntry {

    private int id;
    private int patientId;
    private String entry;
    private Date startDate;
    private Date endDate;
    private Condition condition;
    private Doctor doctor;

    public JournalEntry(int id, int patientId, int personnelId, String entry, Date startDate, Date endDate, Condition condition, Doctor doctor) {
        this.id = id;
        this.patientId = patientId;
        this.entry = entry;
        this.startDate = startDate ;
        this.endDate = endDate;
        this.condition = condition;
        this.doctor = doctor;

    }

    public JournalEntry() {
    }

    public int getId() {
        return id;
    }

    public int getPatientId() {
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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
