package com.example.emailsender.service;

import com.example.emailsender.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Since we are not using a database, let's simulate user fetching
    public User findUserByUsername(String username) {
        // This is just a simulated example. Replace this with actual logic if needed.
        if ("user".equals(username)) {
            return new User("user", "password", "user@example.com");
        } else {
            return null;
        }
    }
}
