package com.oceanview.model;

public class User {

    private int id;
    private String username;
    private String password;
    private String role;

    // No-arg constructor
    public User() {}

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {   // ✅ THIS FIXES THE ERROR
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}