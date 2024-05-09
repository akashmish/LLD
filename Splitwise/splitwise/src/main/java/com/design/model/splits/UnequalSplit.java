package com.design.model.splits;

import com.design.model.Split;

public class UnequalSplit implements SplitType{

    @Override
    public boolean isSplitValid(Split split) {
        return true;
    }
    
}
