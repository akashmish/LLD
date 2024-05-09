package com.design.controller;

import java.util.List;

import com.design.enums.SplitTypeEnum;
import com.design.model.*;
import com.design.model.expense.*;
import com.design.service.ExpenseService;

public class ExpenseController {
    
    //create group expense
    //create individaul expnse
    ExpenseService expenseService;

    public void createExpense(Split split){
        expenseService.createExpense(split);
    }
    
    
}
