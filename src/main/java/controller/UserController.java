package com.example.emailsender.controller;

import com.example.emailsender.model.User;
import com.example.emailsender.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Handle GET request to display login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // This should return the name of the login view (login.html)
    }

    // Handle POST request to process login form
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        // Create a new User object with the input values
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        try {
            // Save the user to the database
            userService.saveUser(user);
            System.out.println("User saved successfully: " + username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/send-email";  // Redirect after login
    }
    @GetMapping("/send-email")
    public String showSendEmailPage() {
        return "send-email";  // This will return the send-email.html view
    }
}
