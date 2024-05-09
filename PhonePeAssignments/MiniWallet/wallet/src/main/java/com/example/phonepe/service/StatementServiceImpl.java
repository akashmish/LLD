package com.example.phonepe.service;

import java.time.LocalDateTime;
import java.util.Map;

import com.example.phonepe.entity.Transaction;
import com.example.phonepe.entity.User;
import com.example.phonepe.entity.Wallet;
import com.example.phonepe.enums.TransactionType;
import com.example.phonepe.storage.Storage;
import java.sql.Timestamp;
import java.time.LocalDateTime;


public class StatementServiceImpl implements StatementService{

    private final Map<User,Wallet> userWalletDb = Storage.getWallets();


    @Override
    public void logTransaction(User user, String otherEntity, TransactionType type, double amount, boolean isSystemTransaction) {
        userWalletDb.get(user).getTransactions().add(new Transaction(userWalletDb.get(user).getWalletId(), Timestamp.valueOf(LocalDateTime.now()),
                type, otherEntity,amount, isSystemTransaction));
    }

    
    @Override
    public void getTransactions(User user) {
        System.out.println("Statement "+ user.getName());
        if(user == null) {
            System.out.println("User: %s doesn't exist");
        }
        else{
            userWalletDb.get(user).getTransactions().forEach(transaction -> {
                String type = transaction.getType() == TransactionType.CREDITED ? " credit " : " debit ";
                System.out.println(transaction.getOtherEntity()+ type + transaction.getAmount() );
            });
        }
    }
    
}
