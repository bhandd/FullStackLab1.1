package com.example.FullStackLab11.model;

public class RegisterForm {
    private String username;
    private String password;
    private String email;
    private long social_number;
    private int role;

    public RegisterForm(String username, String password, String email, long social_number, int role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.social_number = social_number;
        this.role = role;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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
