package com.example.emailsender.controller;

import com.example.emailsender.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        // Since we no longer have a database, we simulate user validation
        if ("user".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid credentials!";
        }
    }
}
