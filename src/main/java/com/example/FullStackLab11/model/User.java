package com.example.FullStackLab11.model;


import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long social_number;
    private String role;


    public User(long id, String name, long social_number, String role) {
        this.id = id;
        this.name = name;
        this.social_number = social_number;
        this.role = role;
    }

    public User(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSocial_number() {
        return social_number;
    }

    public void setSocial_number(long social_number) {
        this.social_number = social_number;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
