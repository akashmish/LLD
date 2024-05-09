package com.example.phonepe.service;

import com.example.phonepe.entity.User;

public interface OfferService {
    void checkAndApplyOffer(User fromUser, User toUser);

    void firstTransactionOffer(User fromUser,double amount);
}
