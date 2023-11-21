package com.example.expensetracker.controllers;

import com.example.expensetracker.entities.ExpenseCategory;
import com.example.expensetracker.services.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expense-category")
public class ExpenseCategoryController {

    @Autowired
    private ExpenseCategoryService expenseCategoryService;

    // Get expense category details
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseCategory> getExpenseCategoryById(@PathVariable Long id) {
        ExpenseCategory expenseCategory = expenseCategoryService.getExpenseCategoryById(id);
        if (expenseCategory != null) {
            return new ResponseEntity<>(expenseCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new expense category
    @PostMapping("/create")
    public ResponseEntity<ExpenseCategory> createUser(@RequestBody ExpenseCategory newExpenseCategory) {
        System.out.println("ExpenseCategory create hit");
        ExpenseCategory expenseCategory = expenseCategoryService.createExpenseCategory(newExpenseCategory);
        if (expenseCategory != null) {
            return new ResponseEntity<>(expenseCategory, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
