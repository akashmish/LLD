package com.example.phonepe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.phonepe.entity.Transaction;
import com.example.phonepe.entity.User;
import com.example.phonepe.entity.Wallet;
import com.example.phonepe.storage.Storage;

public class WalletServiceImpl implements WalletService{

    private final Map<User,Wallet> userWalletDb = Storage.getWallets();

    @Override
    public void createWallet(User user) {
        Wallet newWallet = new Wallet(user, 0);
        userWalletDb.put(user, newWallet);
        // // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'createWallet'");
    }

    @Override
    public void topUpWallet(User user,double amount) throws Exception{
        Wallet userWallet =userWalletDb.get(user);
        if(userWallet!=null){
            if(amount > 0){
                userWallet.addBalance(amount);
                System.out.println("Balance added");
            }else{
                throw new Exception("wallet balance cannot be less than 1");
            }
        }else{
            throw new Exception("wallet not active for specific user");
        } 
    }


    @Override
    public void overview(User user) {
        Wallet userWallet = userWalletDb.get(user);
        System.out.println(userWallet.toString());
    }

    @Override
    public void fetchBalance(User user){
        Wallet userWallet = userWalletDb.get(user);
        System.out.println(userWallet.getBalance());
    }

    @Override 
    public void getTransactions(User user){
        Wallet userWallet = userWalletDb.get(user);
        List<Transaction> userTransactions = userWallet.getTransactions();
        userTransactions.forEach(n -> n.toString());
    }
}
