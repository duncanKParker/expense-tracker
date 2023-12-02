package com.example.expensetracker.controllers;

import com.example.expensetracker.LoginRequest;
import com.example.expensetracker.entities.UserAccount;
import com.example.expensetracker.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    // Get user details
    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getUserById(@PathVariable Long id) {
        UserAccount userAccount = userAccountService.getUserById(id);
        if (userAccount != null) {
            return new ResponseEntity<>(userAccount, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new user
    @PostMapping("/create")
    public ResponseEntity<UserAccount> createUser(@RequestBody UserAccount newUserAccount) {
        System.out.println("Users Create hit");
        UserAccount userAccount = userAccountService.createUser(newUserAccount);
        if (userAccount != null) {
            return new ResponseEntity<>(userAccount, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // User login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        Long userId = userAccountService.authenticateUserAndGetId(loginRequest);
        if (userId != null) {
            // Return the user ID
            return new ResponseEntity<>(userId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }

}
