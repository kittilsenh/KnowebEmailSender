package com.example.emailsender.model;

public class User {
    private Long id;  // Auto-increment
    private String username;
    private String password;

    // Ensure no default values are set here
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
}

