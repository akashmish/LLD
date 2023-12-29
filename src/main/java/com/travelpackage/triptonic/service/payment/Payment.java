package com.travelpackage.triptonic.service.payment;

import com.travelpackage.triptonic.models.Reservation;

public interface Payment {
    
    String doPayment(Reservation resvationDetails);
}
