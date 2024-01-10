package com.travelpackage.triptonic.service.payment;
import com.travelpackage.triptonic.enums.PassengerType;
import com.travelpackage.triptonic.models.Passenger;
import com.travelpackage.triptonic.models.Reservation;

public class StandardPayment implements Payment{

    @Override
    public String doPayment(Reservation resvationDetails) {
        Passenger passenger = resvationDetails.getDemoPassenger();
        if(resvationDetails.getTotCost().compareTo(passenger.getBalance())>0){
          return "Insufficient Balance";
        }
        return "Success"; 
    }
}
