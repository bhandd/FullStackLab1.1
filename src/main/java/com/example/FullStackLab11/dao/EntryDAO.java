package com.example.FullStackLab11.dao;

import com.example.FullStackLab11.model.JournalEntry;
import com.example.FullStackLab11.model.User;

import java.util.ArrayList;
import java.util.List;

public class EntryDAO {
    public static JournalEntry FromDBtoBO(JournalEntryDB journalEntryDB) {
        return new JournalEntry(
                journalEntryDB.getId(),
                journalEntryDB.getPatientId(),
                journalEntryDB.getEntry(),
                journalEntryDB.getStartDate(),
                journalEntryDB.getEndDate(),
                journalEntryDB.gethealthStatus());
    }

    public static List<JournalEntry> FromDBtoBO(List<JournalEntryDB> journalEntryDB) {
        List<JournalEntry> newJournalEntries = new ArrayList<>();
        for (JournalEntryDB entry : journalEntryDB) {
            newJournalEntries.add(FromDBtoBO(entry));
        }
        return newJournalEntries;
    }

    public static JournalEntryDB FromBOtoDB(JournalEntry journalEntry) {
        return new JournalEntryDB(
                journalEntry.getId(),
                journalEntry.getPatientId(),
                journalEntry.getEntry(),
                journalEntry.getStartDate(),
                journalEntry.getEndDate(),
                journalEntry.gethealthStatus());
    }

    public static List<JournalEntryDB> FromBOtoDB(List<JournalEntry> entries) {
        List<JournalEntryDB> newEntries = new ArrayList<>();
        for (JournalEntry entry : entries) {
            newEntries.add(FromBOtoDB(entry));
        }
        return newEntries;
    }
}
