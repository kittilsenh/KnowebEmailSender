package com.example.emailsender.service;

import com.example.emailsender.model.Email;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    // Since we are not using a database, we don't need to save emails anywhere.
    public void sendEmail(Email email) {
        // Placeholder for email sending logic
        System.out.println("Sending email to: " + email.getToAddress());
    }
}