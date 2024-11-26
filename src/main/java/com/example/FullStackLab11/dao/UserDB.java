package com.example.FullStackLab11.dao;

import jakarta.persistence.*;

@Entity
public class UserDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "social_number")
    private long social_number;
    @Column(name = "role")
    private int role;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;

    public UserDB(long id, String name, long social_number, int role, String password) {
        this.id = id;
        this.name = name;
        this.social_number = social_number;
        this.role = role;
        this.password = password;
    }
    public UserDB(long id, String name, long social_number, int role) {
        this.id = id;
        this.name = name;
        this.social_number = social_number;
        this.role = role;
    }
    public UserDB(String name, long social_number, int role, String password, String email) {
        this.name = name;
        this.social_number = social_number;
        this.role = role;
        this.password = password;
        this.email = email;
    }

    public UserDB(){

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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
