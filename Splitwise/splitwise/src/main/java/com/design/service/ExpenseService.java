package com.design.service;

import java.util.List;

import com.design.factory.SplitFactory;
import com.design.model.Split;
import com.design.model.splits.*;

public class ExpenseService {
    
    BalanceService balanceService;


    public ExpenseService(SplitService splitService) {
    }

    public void createExpense(Split split) {
            SplitFactory splitFactory = new SplitFactory();
            SplitType typeOfSplit = splitFactory.getSplitFactory(split.getSplitType());
            if(typeOfSplit.isSplitValid(split)){
                
            }
    }


}
