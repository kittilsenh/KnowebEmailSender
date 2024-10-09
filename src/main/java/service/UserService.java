package com.example.emailsender.service;

import com.example.emailsender.model.User;
import com.example.emailsender.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) throws SQLException {
        userRepository.saveUser(user);
    }
}
