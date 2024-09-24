package com.example.emailsender.controller;

import com.example.emailsender.service.EmailService;  // Ensure this import matches your service package
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class EmailController {

    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private EmailService emailService;

    @GetMapping("/sendEmail")
    public String sendEmail(@RequestParam(defaultValue = "test@example.com") String to,
                            @RequestParam(defaultValue = "Test Subject") String subject,
                            @RequestParam(defaultValue = "Test Body") String body) {
        // Log contextual information at the controller level
        logger.info("Received request to send email to: {} with subject: '{}' and body: '{}'", to, subject, body);

        emailService.sendSimpleEmail(to, subject, body);
        return "Email sent successfully!";
    }
}
