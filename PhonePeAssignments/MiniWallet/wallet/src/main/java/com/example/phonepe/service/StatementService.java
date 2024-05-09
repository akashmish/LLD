package com.example.phonepe.service;

import com.example.phonepe.entity.User;
import com.example.phonepe.enums.TransactionType;

public interface StatementService {
    void logTransaction(User user, String otherEntity, TransactionType type, double amount, boolean isSystemTransaction);

    void getTransactions(User user);
}
