package com.example.phonepe.service;

import com.example.phonepe.entity.User;

public interface TransactionService {
    public void sendMoney(User fromUser, User toUser, double amount);
}
