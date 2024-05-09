package com.example.phonepe;

import com.example.phonepe.entity.User;
import com.example.phonepe.service.OfferService;
import com.example.phonepe.service.OfferServiceImpl;
import com.example.phonepe.service.StatementService;
import com.example.phonepe.service.StatementServiceImpl;
import com.example.phonepe.service.TransactionService;
import com.example.phonepe.service.TransactionServiceImpl;
import com.example.phonepe.service.WalletService;
import com.example.phonepe.service.WalletServiceImpl;

public class Main {
    public static void main(String[] args) throws Exception {

        StatementService statementService = new StatementServiceImpl();
        WalletService walletService = new WalletServiceImpl();
        OfferService offerService = new OfferServiceImpl(statementService);
        TransactionService transactionService = new TransactionServiceImpl(offerService,statementService);


        //Create User
        User fromUser = new User("Aman");
        User toUser = new User("Chaman");
        //Create Wallets/ register wallets
        walletService.createWallet(fromUser);
        walletService.createWallet(toUser);

        //checking status before transaction
        walletService.overview(toUser);
        walletService.overview(fromUser);

        //add balance to from user
        walletService.topUpWallet(fromUser, 300);
        //checking after adding baalnce
        walletService.overview(fromUser);

        //do a transaction 
        transactionService.sendMoney(fromUser, toUser, 250);

        // Status after sening money
        System.out.println("------------------");
        walletService.overview(toUser);
        System.out.println("------------------");

        System.out.println("");
        System.out.println("------------------");
        walletService.overview(fromUser);
        System.out.println("------------------");
        System.out.println("");

        //fetch balance
        walletService.fetchBalance(toUser);

        walletService.fetchBalance(fromUser);

        System.out.println("------------------");
        statementService.getTransactions(fromUser);
        System.out.println("------------------");

    }
}