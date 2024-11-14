package com.example.FullStackLab11.controller;
import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.core.joran.spi.HttpUtil;
import com.example.FullStackLab11.model.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
//@RequestMapping("/patients")
public class PatientController {

    private List<Patient> patients = createList();

    /**När användaren kallar på /employees så returneras en lista med alla anställda.
     * */
    @RequestMapping(value = "/patients", method = RequestMethod.GET,
            produces = "application/json")
    public List<Patient> getPatients() {
        return patients;
    }

    /** Get a patient based on id
     *  **/
    @RequestMapping(value = "/patients/{id}", method = RequestMethod.GET,
            produces = "application/json")
    public Patient getPatientById(@PathVariable("id") long id) {
        return patients.stream()
                .filter(patient -> patient.getId() == id)
                .findFirst()
                .orElse(null);  // or handle not found case differently
    }

/** Delete a patient
 * */
    @RequestMapping (value = "/patients/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<String> removePatientById(@PathVariable("id") Long id) {
        boolean removed = patients.removeIf(patient -> patient.getId() == id);

        if (removed) {
            return ResponseEntity.ok("Patient removed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }
    }


    /** Post a new patient
     * */

    @RequestMapping(value = "/patients",method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient newPatient) {
        // Assign a new ID to the patient if necessary
        newPatient.setId(1); // Assuming you have a method to generate unique IDs

        // Add the new patient to the list (or database if using a DB)
        patients.add(newPatient);

        // Return a 201 Created response with the new patient object
        return ResponseEntity.status(HttpStatus.CREATED).body(newPatient);
    }

    //TODO: testa denna i webbläsaren me en js request
    /**
     * Update an existing patient
     * */
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        System.out.println("updatePatient initiated");
        for (Patient patient : patients) {
            if (patient.getId()==id) { // Använd equals för att jämföra Long-objekt
                patient.setName(updatedPatient.getName());
                patient.updateJournal(updatedPatient.getJournal());
                // Uppdatera andra fält som behövs
                return ResponseEntity.ok(patient); // Returnera den uppdaterade patienten
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Returnera 404 om patienten inte hittas
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