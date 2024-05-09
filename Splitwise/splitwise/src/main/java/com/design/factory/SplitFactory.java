package com.design.factory;

import com.design.enums.SplitTypeEnum;
import com.design.model.splits.EqualSplit;
import com.design.model.splits.PercantageSplit;
import com.design.model.splits.SplitType;
import com.design.model.splits.UnequalSplit;

public class SplitFactory {
    
    public SplitType getSplitFactory(SplitTypeEnum type){
        if(type.equals(SplitTypeEnum.EQUAL)) return new EqualSplit();
        if(type.equals(SplitTypeEnum.UNEQUAL)) return new UnequalSplit();
        if(type.equals(SplitTypeEnum.PERCENTAGE)) return new PercantageSplit();
        return null;
    }
}
