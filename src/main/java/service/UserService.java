package com.example.emailsender.service;

import com.example.emailsender.model.User;
import com.example.emailsender.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  // Create password encoder

    // Save user with hashed password
    public void saveUser(User user) {
        // Hash the password before saving
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        try {
            userRepository.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Find user by username
    public User findUserByUsername(String username) {
        try {
            return userRepository.findUserByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Check if password matches the stored hash
    public boolean checkPassword(User user, String rawPassword) {
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }
}
