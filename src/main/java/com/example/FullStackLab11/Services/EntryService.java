package com.example.FullStackLab11.Services;

import com.example.FullStackLab11.Repositories.EntryRepository;
import com.example.FullStackLab11.dao.JournalEntryDB;
import com.example.FullStackLab11.model.JournalEntry;
import com.example.FullStackLab11.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    // Create
    public void saveEntry(JournalEntryDB entry) {
        entryRepository.save(entry);
    }

    // Read
    public List<JournalEntryDB> getAllEntries() {
        return (List<JournalEntryDB>) entryRepository.findAll();
    }

}
