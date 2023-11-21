package com.example.expensetracker.repositories;

import com.example.expensetracker.entities.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory, Long> {

    //Add a get all expense categories

    //Add a get all expense categories for a specific user

    ExpenseCategory findByExpenseName(String expenseName);

}

