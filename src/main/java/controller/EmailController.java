package com.example.emailsender.controller;

import com.example.emailsender.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    // Display the email form page
    @GetMapping("/send-email-form")
    public String showEmailForm() {
        return "send-email"; // This refers to the `send-email.html` template
    }

    // Handle form submission and send email
    // Handle form submission and send email
    @PostMapping("/sendEmail")
    public ModelAndView sendEmail(@RequestParam String to,
                                  @RequestParam String subject,
                                  @RequestParam String body) {
        emailService.sendSimpleEmail(to, subject, body);

        // Redirect to a success page after sending the email
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("email-success"); // email-success.html page
        modelAndView.addObject("to", to);
        return modelAndView;
    }
}