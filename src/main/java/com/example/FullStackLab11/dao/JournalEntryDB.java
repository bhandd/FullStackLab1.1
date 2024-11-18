package com.example.FullStackLab11.dao;

import com.example.FullStackLab11.model.HealthStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "journal_entries")
public class JournalEntryDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "patient_id", nullable = false)
    private long patientId;
    @Column(name = "entry", nullable = false)
    private String entry;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "health_status")
    private HealthStatus condition;

    public JournalEntryDB(long id, long patientId, String entry, Date startDate, Date endDate, HealthStatus condition) {
        this.id = id;
        this.patientId = patientId;
        this.entry = entry;
        this.startDate = startDate ;
        this.endDate = endDate;
        this.condition = condition;

    }

    public JournalEntryDB() {
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
}
