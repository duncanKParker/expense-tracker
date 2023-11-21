package com.example.expensetracker.services;

import com.example.expensetracker.entities.ExpenseCategory;
import com.example.expensetracker.repositories.ExpenseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseCategoryService {

    @Autowired
    private ExpenseCategoryRepository expenseCategoryRepository;

    // Get user by ID
    public ExpenseCategory getExpenseCategoryById(Long id) {
        return expenseCategoryRepository.findById(id).orElse(null);
    }

    // Create a new user
    public ExpenseCategory createExpenseCategory(ExpenseCategory newExpenseCategory) {
        return expenseCategoryRepository.save(newExpenseCategory);
    }

}
