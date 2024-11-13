package com.example.FullStackLab11.controller;
import java.util.ArrayList;
import java.util.List;

import com.example.FullStackLab11.model.Employee;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployeeController {

    private List<Employee> employees = createList();

    /**När användaren kallar på /employees så returneras en lista med alla anställda.
     * */
    @RequestMapping(value = "/employees", method = RequestMethod.GET,
            produces = "application/json")
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * Returnerar denna lista
     * */
    private static List<Employee> createList() {
        List<Employee> tempEmployees = new ArrayList<>();

        Employee emp1 = new Employee();
        emp1.setName("emp1");
        emp1.setId(1);
        emp1.setDepartment("HR");

        Employee emp2 = new Employee();
        emp2.setName("emp2");
        emp2.setId(2);
        emp2.setDepartment("Finance");
//comment
        Employee emp3 = new Employee();
        emp3.setName("emp3");
        emp3.setId(3);
        emp3.setDepartment("Finance");

        tempEmployees.add(emp1);
        tempEmployees.add(emp2);
        tempEmployees.add(emp3);

        return tempEmployees;
    }

}