package com.example.FullStackLab11.model;

import java.util.Date;

public class JournalEntry {

    private long id;
    private long patientId;
    private String entry;
    private Date startDate;
    private Date endDate;
    private HealthStatus condition;
    private Journal journal;

    public JournalEntry(long id, long patientId, String entry, Date startDate, Date endDate, HealthStatus condition) {
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

    public void setId(long id) {
        this.id = id;
    }

    public void setPatientId(long patientId) {
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

    public HealthStatus getCondition() {
        return condition;
    }

    public void setCondition(HealthStatus condition) {
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
