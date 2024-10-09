package com.example.emailsender.controller;

import com.example.emailsender.model.User;
import com.example.emailsender.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    // In RegisterController.java
    @PostMapping("/user/register")  // Changed to avoid conflict
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("email") String email) {
        // Registration logic
        return "redirect:/login";
    }
}