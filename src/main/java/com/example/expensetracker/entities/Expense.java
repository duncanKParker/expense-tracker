package com.example.expensetracker.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private BigDecimal amount;

    @Getter
    @Setter
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;

    @ManyToOne
    @JoinColumn(name = "expense_category_id")
    private ExpenseCategory category;

    @Getter
    @Setter
    private LocalDateTime expenseDateTime;

}
