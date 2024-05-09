package com.example.phonepe.service;

import java.util.Map;

import javax.swing.text.Utilities;

import com.example.phonepe.entity.User;
import com.example.phonepe.entity.Wallet;
import com.example.phonepe.enums.TransactionType;
import com.example.phonepe.helper.Constants;
import com.example.phonepe.helper.Util;
import com.example.phonepe.storage.Storage;

public class TransactionServiceImpl implements TransactionService {
    // private final MemoryDataStore dataStore;
    private final OfferService offerService;
    private final StatementService statementService;
    private final Map<User,Wallet> userWalletDb = Storage.getWallets();


    public TransactionServiceImpl(OfferService offerService,StatementService statementService) {
        this.offerService = offerService;
        this.statementService = statementService;
    }

    @Override
    public void sendMoney(User fromUser, User toUser, double amount) {
        amount = Util.round(amount, Constants.DECIMAL_VALUES);
        if(amount < Constants.MINIMUM_TRANSACTION_AMOUNT) {
            System.out.println("Minimum amount required is: "+Constants.MINIMUM_TRANSACTION_AMOUNT);
        }
        else {
            if(fromUser == null || toUser == null ){
                System.out.println("Invalid user");
                return;
            }
            boolean canMakeTransaction = validateMinimumAmount(fromUser, amount);
            if(!canMakeTransaction) {
                System.out.println("Insufficient balance");
            }
            else{
                offerService.firstTransactionOffer(fromUser,amount);
                userWalletDb.get(fromUser).reduceBalance(amount);
                userWalletDb.get(toUser).addBalance(amount);
                offerService.checkAndApplyOffer(fromUser, toUser);
                statementService.logTransaction(fromUser, toUser.getName(), TransactionType.DEBITED, amount, false);
                statementService.logTransaction(toUser, fromUser.getName(), TransactionType.CREDITED, amount, false);
                System.out.println("Money Sent successfully");
            }
        }
    }

    private boolean validateMinimumAmount(User fromUser, double amount) {
        return userWalletDb.get(fromUser).getBalance() - amount > 0;
    }
}
