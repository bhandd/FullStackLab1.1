package com.example.FullStackLab11.Repositories;

import com.example.FullStackLab11.dao.JournalEntryDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends CrudRepository<JournalEntryDB, Long> {
    List<JournalEntryDB> getEntriesByPatientId(long patientId);
}