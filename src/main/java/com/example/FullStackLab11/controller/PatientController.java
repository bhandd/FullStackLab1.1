package com.example.FullStackLab11.controller;
import java.util.List;
import java.util.Objects;

import com.example.FullStackLab11.Services.UserService;
import com.example.FullStackLab11.dao.UserDAO;

import com.example.FullStackLab11.dao.UserDB;
import com.example.FullStackLab11.model.LoginForm;
import com.example.FullStackLab11.model.RegisterForm;
import com.example.FullStackLab11.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PatientController {

    @Autowired
    private UserService userService;

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

    // GET a patient or non-patient
    @RequestMapping(value = {"/patients/{id}", "/staff/{id}"}, method = RequestMethod.GET,
            produces = "application/json")
    public User getUserById(@PathVariable("id") long id) {
        return UserDAO.FromDBtoBO(userService.getUserById(id));
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


    //TODO: testa denna i webbläsaren me en js request
    /**
     * Update an existing patient
     * */
    @RequestMapping(value = "/patients/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<User> updatePatient(@PathVariable long id, @RequestBody User updatedPatient) {
        System.out.println("updatePatient initiated");
        User updatedUser = UserDAO.FromDBtoBO(userService.updateUser(id, UserDAO.FromBOtoDB(updatedPatient)));

        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser); // Return the updated user
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Return 404 if user not found
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<LoginForm> validateUser (@RequestBody LoginForm credentials) {
        System.out.println(credentials.getUsername() + ", " + credentials.getPassword());
        if (Objects.equals(credentials.getUsername(), "admin") && Objects.equals(credentials.getPassword(), "admin")) {
            return ResponseEntity.ok(new LoginForm("ADMIN", "Admin"));
        }
        User user = UserDAO.FromDBtoBO(userService.validateNewUser(credentials));

        if (user != null) {
            return ResponseEntity.ok(new LoginForm(credentials.getUsername(), credentials.getPassword()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<LoginForm> registerNewUser (@RequestBody RegisterForm form) {
        System.out.println(form.toString());
        UserDB userDB = new UserDB(form.getUsername(), form.getSocial_number(), form.getRole(), form.getPassword(), form.getEmail());
        userService.registerNewUser(userDB);
        return ResponseEntity.ok(new LoginForm(form.getUsername(), form.getPassword()));
    }



    /**
     * Returnerar denna lista
     * */
    /*private static List<Patient> createList() {
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

    }*/

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