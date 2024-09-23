package com.example.emailsender.controller;

import com.example.emailsender.service.EmailService;  // Ensure this import matches your service package
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;  // Ensure EmailService is injected correctly

    @GetMapping("/sendEmail")
    public String sendEmail(@RequestParam(defaultValue = "test@example.com") String to,
                            @RequestParam(defaultValue = "Test Subject") String subject,
                            @RequestParam(defaultValue = "Test Body") String body) {
        emailService.sendSimpleEmail(to, subject, body);
        return "Email sent successfully!";
    }

}
