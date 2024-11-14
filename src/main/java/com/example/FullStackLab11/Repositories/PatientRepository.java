package com.example.FullStackLab11.Repositories;

import com.example.FullStackLab11.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {

}