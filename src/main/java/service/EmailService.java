package com.example.emailsender.service;

import com.example.emailsender.model.User;
import com.example.emailsender.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepository userRepository;

    public void sendSimpleEmail(String to, String subject, String body) {
        try {
            logger.info("Attempting to send email to: {}", to);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);

            // Log success
            logger.info("Email sent successfully to: {}", to);

            // Save user email details in the database
            User user = new User(to, subject, body);
            userRepository.save(user);

        } catch (Exception e) {
            logger.error("Error while sending email to: {} - Error: {}", to, e.getMessage(), e);
        }
    }
}
