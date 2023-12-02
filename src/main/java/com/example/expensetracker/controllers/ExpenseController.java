package com.example.expensetracker.controllers;

import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.entities.Expense;
import com.example.expensetracker.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    //Add a get all expenses for a user to populate the list
    //Might need to make /allUserExpenses/{userId}
    @GetMapping("/{userId}")
    public ResponseEntity<List<Expense>> getAllExpensesForUser(@PathVariable Long userId){
        System.out.println("All expenses by user id hit");
        List<Expense> expenses = expenseService.getAllExpensesByUserId(userId);
        if (!expenses.isEmpty()) {
            return new ResponseEntity<>(expenses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Add get all expenses for a user of a specific category to popoulate the list
//    @GetMapping("/users/{userId}/categories/{categoryId}")
//    public ResponseEntity<List<Expense>> getAllExpensesForUserByCategory(@PathVariable Long userId, @PathVariable Long categoryId){
//        List<Expense> expenses = expenseService.getAllExpensesByUserIdAndCategoryId(userId, categoryId);
//        if (!expenses.isEmpty()) {
//            return new ResponseEntity<>(expenses, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

//    // Get user details
    //Removed this since it might be causing duplicate methods being called by front end. Might need to be /expenseById/{id}
////    @GetMapping("/{id}")
////    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
////        Expense expense = expenseService.getExpenseById(id);
////        if (expense != null) {
////            return new ResponseEntity<>(expense, HttpStatus.OK);
////        } else {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        }
////    }

    // Create a new user
    @PostMapping("/create")
    public ResponseEntity<Expense> createExpense(@RequestBody ExpenseDTO expenseDTO) {
        System.out.println("Expense Create hit");
        Expense expense = expenseService.createExpense(expenseDTO);
        if (expense != null) {
            return new ResponseEntity<>(expense, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
