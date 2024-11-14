package com.example.FullStackLab11.model;

import jakarta.persistence.Entity;

public class Doctor extends User {


    public Doctor(int id, String name) {
        super(id, name);
    }

    public Doctor(){

    }
}
