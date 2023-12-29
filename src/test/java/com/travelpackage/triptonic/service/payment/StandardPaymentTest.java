package com.travelpackage.triptonic.service.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.travelpackage.triptonic.controller.TravelPackageManager;
import com.travelpackage.triptonic.enums.PassengerType;
import com.travelpackage.triptonic.models.Passenger;
import com.travelpackage.triptonic.models.Reservation;


public class StandardPaymentTest {
    @Test
    void testDoPayment() {
        TravelPackageManager tpm = new TravelPackageManager();
        Passenger passenger = new Passenger("AKASH", new BigDecimal(30), 01, PassengerType.STANDARD);
        Reservation testReservation = new Reservation();
        testReservation.setDemoPassenger(passenger);
        testReservation.setTotCost(new BigDecimal(100));
		PymentStrategy paymentStrategy = new PymentStrategy(testReservation.getDemoPassenger().getType());
		String paymentStatus = paymentStrategy.executeStrategy(testReservation);
        assertEquals("Insufficient Balance", paymentStatus);
    }
}
