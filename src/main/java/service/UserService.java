package com.example.emailsender.service;

import com.example.emailsender.model.User;
import com.example.emailsender.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        try {
            userRepository.saveUser(user);  // Save the user to the database
        } catch (Exception e) {
            e.printStackTrace();  // Handle any exceptions here
        }
    }

    public User findUserByUsername(String username) {
        try {
            return userRepository.findUserByUsername(username);  // Find the user by username
        } catch (Exception e) {
            e.printStackTrace();  // Handle any exceptions here
        }
        return null;  // Return null if user is not found or an error occurred
    }
}
