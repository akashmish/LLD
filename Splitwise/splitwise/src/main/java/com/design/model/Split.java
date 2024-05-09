package com.design.model;

import java.util.List;

import com.design.enums.SplitTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Split {
    double amountPaid;
    User paidBy;
    List<User> userInvolved;
    SplitTypeEnum splitType;
    List<Double> splitValues;
}
