package com.example.expensetracker.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExpenseDTO {
    @Getter
    @Setter
    private BigDecimal amount;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private Long userAccountId;
    @Getter
    @Setter
    private Long categoryId;
    @Getter
    @Setter
    private LocalDateTime expenseDateTime;
}

