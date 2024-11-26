package com.example.FullStackLab11.model;

public class RegisterForm {
    private String registerUserName;
    private String registerPassword;
    private String registerEmail;
    private long registerSocialNumber;
    private String registerRole;

    public RegisterForm(String username, String password, String email, long social_number, String role) {
        this.registerUserName = username;
        this.registerPassword = password;
        this.registerEmail = email;
        this.registerSocialNumber = social_number;
        this.registerRole = role;
    }
    public RegisterForm() {

    }

    public String getUsername() {
        return registerUserName;
    }
    public void setUsername(String username) {
        this.registerUserName = username;
    }
    public String getPassword() {
        return registerPassword;
    }
    public void setPassword(String password) {
        this.registerPassword = password;
    }
    public String getEmail() {
        return registerEmail;
    }
    public void setEmail(String email) {
        this.registerEmail = email;
    }
    public long getSocial_number() {
        return registerSocialNumber;
    }
    public void setSocial_number(long social_number) {
        this.registerSocialNumber = social_number;
    }
    public String getRole() {
        return registerRole;
    }
    public void setRole(String role) {
        this.registerRole = role;
    }

    @Override
    public String toString() {
        return registerUserName + ", " + registerPassword + ", " + registerEmail + ", " + registerSocialNumber + ", " + registerRole;
    }
}
