package com.travelpackage.triptonic;

import java.util.List;

import com.travelpackage.triptonic.controller.TravelPackageManager;
import com.travelpackage.triptonic.models.Passenger;
import com.travelpackage.triptonic.models.Reservation;
import com.travelpackage.triptonic.service.payment.PymentStrategy;

public class TriptonicApplication {

	public static void main(String[] args) {
		TravelPackageManager packageManager = new TravelPackageManager();
		Passenger demoPassenger =  packageManager.getPassenegrs().get(0);

		//listing all packages
		packageManager.listPackages();	

		//make a reservation
		Reservation reservationDetails = packageManager.bookPackage(demoPassenger,1,new int[]{1,4,5});

		//pay for the reservation 
		PymentStrategy paymentStrategy = new PymentStrategy(reservationDetails.getDemoPassenger().getType());
		String paymentStatus = paymentStrategy.executeStrategy(reservationDetails);
		if(paymentStatus.equalsIgnoreCase("Success")==true){
			System.out.println("Payment successful");
			//payment successful generate the details
			packageManager.completeReservation(reservationDetails);
		}
		
		//list a package detail for a reservation
		packageManager.listPackageDetails(reservationDetails.getTravelPackage().getId());

		//list all passengers with what packages they have signed up for 
		packageManager.printPassengerDetails();

		//list capacity remaining of each package
		packageManager.listAvailableSpots();
	}

}
