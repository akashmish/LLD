package com.travelpackage.triptonic.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import com.travelpackage.triptonic.enums.PassengerType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Reservation {

    private TravelPackage travelPackage;
    private List<Activity> activtiesSelected;
    private BigDecimal totCost;
    private String reservationId;
    private Passenger demoPassenger;
    
    public Reservation(TravelPackage travelPackage, List<Activity> activtiesSelected, BigDecimal totCost,Passenger demoPassenger) {
        this.travelPackage = travelPackage;
        this.activtiesSelected = activtiesSelected;
        this.totCost = totCost;
        this.reservationId = UUID.randomUUID().toString().replace("-", "");
        this.demoPassenger = demoPassenger;
    }
}
