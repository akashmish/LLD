package com.travelpackage.triptonic.models;

import java.math.BigDecimal;
import java.util.List;
import com.travelpackage.triptonic.enums.PassengerType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Passenger {
    String name;
    BigDecimal balance;
    public Integer passengerNumber;
    PassengerType type;
}
