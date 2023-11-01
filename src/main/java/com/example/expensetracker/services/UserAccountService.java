package com.example.expensetracker.services;

import com.example.expensetracker.LoginRequest;
import com.example.expensetracker.entities.UserAccount;
import com.example.expensetracker.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    // Get user by ID
    public UserAccount getUserById(Long id) {
        return userAccountRepository.findById(id).orElse(null);
    }

    // Create a new user
    public UserAccount createUser(UserAccount newUserAccount) {
        return userAccountRepository.save(newUserAccount);
    }

    // Authenticate user
    public boolean authenticateUser(LoginRequest loginRequest) {
        UserAccount user = userAccountRepository.findByUsername(loginRequest.getUsername());
        return user != null && user.getPassword().equals(loginRequest.getPassword());
    }
}


