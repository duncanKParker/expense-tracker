package com.example.expensetracker.services;

import com.example.expensetracker.entities.Expense;
import com.example.expensetracker.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Get expense by ID
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    // Create a new expense
    public Expense createExpense(Expense newExpense) {
        return expenseRepository.save(newExpense);
    }

}
