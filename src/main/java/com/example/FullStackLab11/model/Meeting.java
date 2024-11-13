package com.example.FullStackLab11.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Meeting {

        private int meetingId;
        private Doctor doctor;
        private Patient patient;
        private Date startTime;
        private Date endTime;
        private List<String> notes;

    public Meeting(Doctor doctor, Patient patient, Date startTime, Date endTime) {
        this.doctor = doctor;
        this.patient = patient;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<String> getNotes() {
        //Todo: returnera en kopia
        return notes;
    }

    public void addNote(String note) {
        if (notes == null) {
            notes = new ArrayList<>();
        }
        this.notes.add(note);
    }
}
