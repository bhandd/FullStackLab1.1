package com.example.FullStackLab11.controller;
import java.util.ArrayList;
import java.util.List;

import com.example.FullStackLab11.Services.UserService;
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

    @Autowired
    private UserService userService;

    // GET patients
    @RequestMapping(value = "/patients", method = RequestMethod.GET,
            produces = "application/json")
    public List<User> getAllPatients() {
        return userService.getAllPatients();
    }

    // GET all who are not patients
    @RequestMapping(value = "/staff", method = RequestMethod.GET,
            produces = "application/json")
    public List<User> getAllStaff() {
        return userService.getAllStaff();
    }

    // GET
    @RequestMapping(value = "/patients/{id}", method = RequestMethod.GET,
            produces = "application/json")
    public User getPatientById(@PathVariable("id") long id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }
    // GET
    @RequestMapping(value = "/staff/{id}", method = RequestMethod.GET,
            produces = "application/json")
    public User getStaffById(@PathVariable("id") long id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // DELETE
    @RequestMapping (value = "/patients/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<String> removePatientById(@PathVariable("id") long id) {
        /*boolean removed = patients.removeIf(patient -> patient.getId() == id);

        if (removed) {
            return ResponseEntity.ok("Patient removed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }*/

        if (!userService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // POST
    @RequestMapping(value = "/patients", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> createPatient(@RequestBody User newUser) {
        // Assign a new ID to the patient if necessary

        // Add the new patient to the list (or database if using a DB)
        userService.saveUser(newUser);

        // Return a 201 Created response with the new patient object
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    //TODO: testa denna i webbläsaren me en js request
    /**
     * Update an existing patient
     * */
    @RequestMapping(value = "/patients/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<User> updatePatient(@PathVariable long id, @RequestBody User updatedPatient) {
        System.out.println("updatePatient initiated");
        User updatedUser = userService.updateUser(id, updatedPatient);

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