package com.example.phonepe.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import com.example.phonepe.enums.TransactionType;

public class Transaction {
    private UUID uuid;
    private final UUID wallet;
    private final Timestamp madeOn;
    private final TransactionType type;
    private final String otherEntity;
    private final double amount;
    private final boolean isSystemTransaction;

    public Transaction(UUID wallet, Timestamp madeOn, TransactionType type, String otherEntity, double amount, boolean isSystemTransaction) {
        this.wallet = wallet;
        this.madeOn = madeOn;
        this.type = type;
        this.otherEntity = otherEntity;
        this.amount = amount;
        this.isSystemTransaction = isSystemTransaction;
    }

    public UUID getUuid() {
        return uuid;
    }

    public UUID getWallet() {
        return wallet;
    }

    public Timestamp getMadeOn() {
        return madeOn;
    }

    public TransactionType getType() {
        return type;
    }

    public String getOtherEntity() {
        return otherEntity;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isSystemTransaction() {
        return isSystemTransaction;
    }

    @Override
    public String toString() {
        return "Transaction [madeOn=" + madeOn + ", type=" + type + ", otherEntity=" + otherEntity + ", amount="
                + amount + ", isSystemTransaction=" + isSystemTransaction + "]";
    }

}
