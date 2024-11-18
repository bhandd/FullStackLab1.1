package com.example.FullStackLab11.Services;

import com.example.FullStackLab11.Repositories.EntryRepository;
import com.example.FullStackLab11.dao.JournalEntryDB;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    // POST
    public void saveEntry(JournalEntryDB entry) {
        entryRepository.save(entry);
    }

    // READ
    public List<JournalEntryDB> getAllEntries() {
        return (List<JournalEntryDB>) entryRepository.findAll();
    }

    // READ
    public JournalEntryDB getEntryById(long id) {
        return entryRepository.findById(id).orElse(null);
    }

    // READ
    public List<JournalEntryDB> getEntriesByPatientId(long id) {
        List<JournalEntryDB> allEntries = (List<JournalEntryDB>) entryRepository.findAll();
        return allEntries.stream()
                .filter(entry -> entry.getPatientId() == id)
                .collect(Collectors.toList());
    }
}
