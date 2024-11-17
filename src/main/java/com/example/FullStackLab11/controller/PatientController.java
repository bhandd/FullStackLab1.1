package com.example.FullStackLab11.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.FullStackLab11.Services.EntryService;
import com.example.FullStackLab11.Services.MessageService;
import com.example.FullStackLab11.Services.UserService;
import com.example.FullStackLab11.dao.EntryDAO;
import com.example.FullStackLab11.dao.MessageDAO;
import com.example.FullStackLab11.dao.UserDAO;
import com.example.FullStackLab11.dao.UserDB;
import com.example.FullStackLab11.model.JournalEntry;
import com.example.FullStackLab11.model.Message;
import com.example.FullStackLab11.model.Patient;
import com.example.FullStackLab11.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
//@RequestMapping("/patients")
public class PatientController {

    private List<User> users = new ArrayList<User>();
    private List<JournalEntry> entries = new ArrayList<JournalEntry>();
    private List<Message> messages = new ArrayList<>();

    @Autowired
    private UserService userService;
    @Autowired
    private EntryService entryService;
    @Autowired
    private MessageService messageService;

    // GET patients
    @RequestMapping(value = "/patients", method = RequestMethod.GET,
            produces = "application/json")
    public List<User> getAllPatients() {
        return UserDAO.FromDBtoBO(userService.getAllPatients());
    }

    // GET all who are not patients
    @RequestMapping(value = "/staff", method = RequestMethod.GET,
            produces = "application/json")
    public List<User> getAllStaff() {
        return UserDAO.FromDBtoBO(userService.getAllStaff());
    }

    // GET a patient
    @RequestMapping(value = "/patients/{id}", method = RequestMethod.GET,
            produces = "application/json")
    public User getPatientById(@PathVariable("id") long id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }
    // GET a non patient
    @RequestMapping(value = "/staff/{id}", method = RequestMethod.GET,
            produces = "application/json")
    public User getStaffById(@PathVariable("id") long id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }
    // GET entries from a patient
    @RequestMapping(value = "/entries/{id}", method = RequestMethod.GET,
            produces = "application/json")
    public List<JournalEntry> getAllEntries(@PathVariable("id") long id) {
        entries = EntryDAO.FromDBtoBO(entryService.getAllEntries());
        return entries.stream()
                .filter(entry -> entry.getPatientId() == id)
                .collect(Collectors.toList());
    }

    // DELETE
    @RequestMapping (value = "/patients/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<String> removePatientById(@PathVariable("id") long id) {
        if (!userService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // POST
    @RequestMapping(value = "/patients", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> createPatient(@RequestBody User newUser) {
        userService.saveUser(UserDAO.FromBOtoDB(newUser));
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
    // POST
    @RequestMapping(value = "/entry", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<JournalEntry> createPatient(@RequestBody JournalEntry newEntry) {
        entryService.saveEntry(EntryDAO.FromBOtoDB(newEntry));
        return ResponseEntity.status(HttpStatus.CREATED).body(newEntry);
    }
    // POST
    @RequestMapping(value = "/messages", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Message> createPatient(@RequestBody Message newMessage) {
        messageService.saveMessage(MessageDAO.FromBOtoDB(newMessage));
        return ResponseEntity.status(HttpStatus.CREATED).body(newMessage);
    }

    //TODO: testa denna i webbläsaren me en js request
    /**
     * Update an existing patient
     * */
    @RequestMapping(value = "/patients/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<User> updatePatient(@PathVariable long id, @RequestBody User updatedPatient) {
        System.out.println("updatePatient initiated");
        User updatedUser = UserDAO.FromDBtoBO(userService.updateUser(id, UserDAO.FromBOtoDB(updatedPatient)));

        // Check if update was successful
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser); // Return the updated user
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Return 404 if user not found
        }
    }



    /**
     * Returnerar denna lista
     * */
    private static List<Patient> createList() {
        List<Patient> tempPatients = new ArrayList<>();

        Patient emp1 = new Patient();
        emp1.setName("emp1");
        emp1.setId(1);


        Patient emp2 = new Patient();
        emp2.setName("emp2");
        emp2.setId(2);


        Patient emp3 = new Patient();
        emp3.setName("emp3");
        emp3.setId(3);


        tempPatients.add(emp1);
        tempPatients.add(emp2);
        tempPatients.add(emp3);

        return tempPatients;

    }





//    private Patient getPatientById(long id) {
//
//        for (Patient patient : this.patients) {
//            if (patient.getId() == id) {
//                return patient;
//            }
//        }
//        return null;
//    }

}