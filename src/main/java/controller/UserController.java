package com.example.emailsender.controller;

import com.example.emailsender.model.User;
import com.example.emailsender.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Show registration page
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";  // Return the register.html view
    }

    // Handle registration form submission
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // Save user in the database
        userService.saveUser(user);

        return "redirect:/login";  // After registering, redirect to login page
    }

    // Show login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Return the login.html view
    }

    // Handle login form submission
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
        User user = userService.findUserByUsername(username);

        if (user != null) {
            // Check if the password matches the hashed password
            if (userService.checkPassword(user, password)) {
                return "redirect:/send-email";  // Redirect on successful login
            } else {
                redirectAttributes.addFlashAttribute("error", "Invalid password.");
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "User not found.");
        }

        return "redirect:/login";
    }

    // Existing send-email mapping
    @GetMapping("/send-email")
    public String showSendEmailPage() {
        return "send-email";  // Return the send-email.html view
    }
}
