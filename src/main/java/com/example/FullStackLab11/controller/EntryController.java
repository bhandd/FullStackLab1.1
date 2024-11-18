package com.example.FullStackLab11.controller;

import com.example.FullStackLab11.Services.EntryService;
import com.example.FullStackLab11.dao.EntryDAO;
import com.example.FullStackLab11.model.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EntryController {

    private List<JournalEntry> entries = new ArrayList<JournalEntry>();

    @Autowired
    private EntryService entryService;

    // GET all entries
    @RequestMapping(value = "/entries", method = RequestMethod.GET,
            produces = "application/json")
    public List<JournalEntry> getAllEntries() {
        return entries = EntryDAO.FromDBtoBO(entryService.getAllEntries());
    }
    // GET an entry
    @RequestMapping(value = "/entries/{id}", method = RequestMethod.GET,
            produces = "application/json")
    public JournalEntry getEntryById(@PathVariable("id") long id) {
        return EntryDAO.FromDBtoBO(entryService.getEntryById(id));
    }
    // GET all entries for a patient
    @RequestMapping(value = "/entries/p{id}", method = RequestMethod.GET,
            produces = "application/json")
    public List<JournalEntry> getEntriesByPatientId(@PathVariable("id") long id) {
        return EntryDAO.FromDBtoBO(entryService.getEntriesByPatientId(id));
    }

    // POST
    @RequestMapping(value = "/entries", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<JournalEntry> createPatient(@RequestBody JournalEntry newEntry) {
        entryService.saveEntry(EntryDAO.FromBOtoDB(newEntry));
        return ResponseEntity.status(HttpStatus.CREATED).body(newEntry);
    }
}
