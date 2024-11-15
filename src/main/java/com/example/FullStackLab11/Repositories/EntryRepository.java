package com.example.FullStackLab11.Repositories;

import com.example.FullStackLab11.model.JournalEntry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntryRepository extends CrudRepository<JournalEntry, Long> {
    List<JournalEntry> getAllEntries();
}