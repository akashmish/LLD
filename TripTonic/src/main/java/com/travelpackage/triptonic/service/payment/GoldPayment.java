package com.travelpackage.triptonic.service.payment;

import com.travelpackage.triptonic.models.Reservation;

public class GoldPayment implements Payment{

    @Override
    public String doPayment(Reservation resvationDetails) {
        return "Success";
    }
    
}
