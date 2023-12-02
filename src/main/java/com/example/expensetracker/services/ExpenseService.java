package com.example.expensetracker.services;

import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.entities.Expense;
import com.example.expensetracker.entities.ExpenseCategory;
import com.example.expensetracker.entities.UserAccount;
import com.example.expensetracker.repositories.ExpenseCategoryRepository;
import com.example.expensetracker.repositories.ExpenseRepository;
import com.example.expensetracker.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private ExpenseCategoryRepository expenseCategoryRepository;

    // Get expense by ID
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    // Create a new expense
    public Expense createExpense(ExpenseDTO expenseDTO) {
        Expense expense = new Expense();
        expense.setAmount(expenseDTO.getAmount());
        expense.setDescription(expenseDTO.getDescription());
        expense.setExpenseDateTime(expenseDTO.getExpenseDateTime());

        UserAccount userAccount = userAccountRepository.findById(expenseDTO.getUserAccountId()).orElse(null);
        ExpenseCategory category = expenseCategoryRepository.findById(expenseDTO.getCategoryId()).orElse(null);

        expense.setUserAccount(userAccount);
        expense.setCategory(category);

        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpensesByUserId(Long userId) {
        return expenseRepository.findByUserAccountId(userId);
    }

//    public List<Expense> getAllExpensesByUserIdAndCategoryId(Long userId, Long categoryId) {
//    }
}
