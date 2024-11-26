package com.example.FullStackLab11.model;

public class User {

    private long id;
    private String name;
    private long social_number;
    private int role;


    public User(long id, String name, long social_number, int role) {
        this.id = id;
        this.name = name;
        this.social_number = social_number;
        this.role = role;
    }

    public User() {

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
}
