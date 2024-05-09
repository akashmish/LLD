package com.example.phonepe.service;

import java.util.Map;

import com.example.phonepe.entity.User;
import com.example.phonepe.entity.Wallet;
import com.example.phonepe.enums.TransactionType;
import com.example.phonepe.storage.Storage;

public class OfferServiceImpl implements OfferService{

    private final Map<User,Wallet> userWalletDb = Storage.getWallets();
    private final StatementService statementService;

    public OfferServiceImpl(StatementService statementService) {
        this.statementService = statementService;
    }

    @Override
    public void checkAndApplyOffer(User fromUser, User toUser) {
        if(userWalletDb.get(fromUser).getBalance() == userWalletDb.get(toUser).getBalance()) {
            userWalletDb.get(toUser).addBalance(10);
            userWalletDb.get(toUser).addBalance(10);
            System.out.println("Equal balance offer applicable");
            String offer2Name = "Offer1";
            double AMOUNT_OFFER_1 = 10;
            statementService.logTransaction(fromUser, offer2Name, TransactionType.CREDITED, AMOUNT_OFFER_1, true);
            statementService.logTransaction(toUser, offer2Name, TransactionType.CREDITED, AMOUNT_OFFER_1, true);
        }
    }

    @Override
    public void firstTransactionOffer(User fromUser,double amount) {
        Wallet userWallet = userWalletDb.get(fromUser);
        if(userWallet.getNumOfTransactions()==0 && amount>100){
            userWalletDb.get(fromUser).addBalance(amount/10);
            String offer2Name = "firstTransactionOffer";
            double AMOUNT_OFFER_1 = amount/10;
            System.out.println("frist transaction offer applicable");
            statementService.logTransaction(fromUser, offer2Name, TransactionType.CREDITED, AMOUNT_OFFER_1, true);
     
        }
    }
    
}
