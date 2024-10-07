package com.example.emailsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {

    @Autowired
    private JavaMailSender mailSender; // Inject JavaMailSender to send emails

    @Autowired
    private JdbcTemplate jdbcTemplate;  // Inject JdbcTemplate to interact with the database

    @GetMapping("/send-email-form")
    public String showSendEmailForm() {
        return "send-email";  // This will return send-email.html from the templates folder
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam("toAddress") String toAddress,
                            @RequestParam("subject") String subject,
                            @RequestParam("body") String body) {
        try {
            // Create a simple mail message
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toAddress);
            message.setSubject(subject);
            message.setText(body);

            // Send the email
            mailSender.send(message);

            // Insert the email details into the database
            String sql = "INSERT INTO email_record (email, subject, message) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, toAddress, subject, body);

            // After email is sent, redirect to email-success.html
            return "redirect:/email-success";
        } catch (Exception e) {
            // Handle error during sending
            e.printStackTrace();
            return "error";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        try {
            // Store username and password in the users table
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            jdbcTemplate.update(sql, username, password);

            // Redirect to the email sending form after successful login
            return "redirect:/send-email-form";
        } catch (Exception e) {
            e.printStackTrace();
            return "error"; // Handle the error as appropriate
        }
    }





    // Add a mapping for the email success page
    @GetMapping("/email-success")
    public String emailSuccess() {
        return "email-success"; // This will return email-success.html
    }
}
