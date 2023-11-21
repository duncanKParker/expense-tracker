package com.example.expensetracker.controllers;

import com.example.expensetracker.entities.Expense;
import com.example.expensetracker.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    //Add a get all expenses for a user to populate the list

    //Add get all expenses for a user of a specific category to popoulate the list

    // Get user details
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        Expense expense = expenseService.getExpenseById(id);
        if (expense != null) {
            return new ResponseEntity<>(expense, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new user
    @PostMapping("/create")
    public ResponseEntity<Expense> createExpense(@RequestBody Expense newExpense) {
        System.out.println("Users Create hit");
        Expense expense = expenseService.createExpense(newExpense);
        if (expense != null) {
            return new ResponseEntity<>(expense, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
