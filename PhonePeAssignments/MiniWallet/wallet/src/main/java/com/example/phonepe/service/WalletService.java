package com.example.phonepe.service;

import com.example.phonepe.entity.User;

public interface WalletService {
    void createWallet(User user);

    void overview(User user);

    void topUpWallet(User user,double amount) throws Exception;
 
    public void fetchBalance(User user);

    public void getTransactions(User user);

}
