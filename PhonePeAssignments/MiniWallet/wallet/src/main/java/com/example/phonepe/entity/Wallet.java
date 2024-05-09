package com.example.phonepe.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Wallet {
    private UUID walletId;
    private User user;
    private double balance;
    private List<Transaction> transactions;
    private LocalDateTime createdOn;

    public Wallet(User user, double balance) {
        this.user = user;
        this.balance = balance;
        this.transactions = new ArrayList<>();
        this.createdOn = LocalDateTime.now();
    }

    public void reduceBalance(double amount) {
        if(this.balance <= amount) {
            System.out.println("Insufficient balance");
        }
        else{
            this.balance -= amount;
        }
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public int getNumOfTransactions() {
        return this.transactions.size();
    }

    public UUID getWalletId() {
        return walletId;
    }

    public User getUser() {
        return user;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    @Override
    public String toString() {
        return "Wallet [user=" + user + ", balance=" + balance + ", transactions=" + transactions + ", createdOn="
                + createdOn + "]";
    }


    
}
