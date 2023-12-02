package com.example.expensetracker.repositories;

import com.example.expensetracker.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

//    Expense findById(Long id);

    List<Expense> findByUserAccountId(Long userAccountId);

}