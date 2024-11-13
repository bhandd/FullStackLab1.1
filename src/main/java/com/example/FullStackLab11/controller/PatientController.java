package com.example.FullStackLab11.controller;
import java.util.ArrayList;
import java.util.List;

import com.example.FullStackLab11.model.Patient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PatientController {

    private List<Patient> patients = createList();

    /**När användaren kallar på /employees så returneras en lista med alla anställda.
     * */
    @RequestMapping(value = "/patients", method = RequestMethod.GET,
            produces = "application/json")
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Returnerar denna lista
     * */
    private static List<Patient> createList() {
        List<Patient> tempPatients = new ArrayList<>();
//
//     //   Patient emp1 = new Patient();
//        emp1.setName("emp1");
//        emp1.setId(1);
//
//
//        Patient emp2 = new Patient();
//        emp2.setName("emp2");
//        emp2.setId(2);
//
//
//        Patient emp3 = new Patient();
//        emp3.setName("emp3");
//        emp3.setId(3);
//
//
//        tempPatients.add(emp1);
//        tempPatients.add(emp2);
//        tempPatients.add(emp3);
//
//        return tempPatients;
        return null;
    }

}