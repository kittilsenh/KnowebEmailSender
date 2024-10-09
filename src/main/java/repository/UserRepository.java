package com.example.emailsender.repository;

import com.example.emailsender.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UserRepository {

    @Autowired
    private DataSource dataSource;

    public void saveUser(User user) throws SQLException {
        System.out.println("Saving user: " + user.getUsername() + " with password: " + user.getPassword());  // Debugging

        String query = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);  // Confirm rows inserted
        }
    }
}