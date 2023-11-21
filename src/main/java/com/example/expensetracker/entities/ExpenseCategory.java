package com.example.expensetracker.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class ExpenseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false, length = 50)
    private String expenseName;

    // One-to-many relationship with Expenses
    @Getter
    @Setter
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Expense> expenses;

    @Getter
    @Setter
    private LocalDateTime expenseDateTime;

}
