package com.travelpackage.triptonic.service.payment;

import com.travelpackage.triptonic.enums.PassengerType;
import com.travelpackage.triptonic.models.Reservation;

public class PymentStrategy {
    private Payment payment;


   public PymentStrategy(PassengerType passengerType){
      if(passengerType.equals(PassengerType.STANDARD)){
        payment = new StandardPayment();
      }
   }

   public String executeStrategy(Reservation resvationDetails){
    return payment.doPayment(resvationDetails);
 }

}
