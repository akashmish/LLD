package com.example.phonepe.storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.example.phonepe.entity.User;
import com.example.phonepe.entity.Wallet;



public class Storage {
   private static HashMap<User,Wallet> userWalletDb;

    public static Map<User, Wallet>  getWallets() {
        if(Objects.isNull(userWalletDb)){
            userWalletDb = new HashMap<>();
        }
        return userWalletDb;
    }
    
}
