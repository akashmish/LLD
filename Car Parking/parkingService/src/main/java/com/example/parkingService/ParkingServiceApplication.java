package com.example.parkingService;

import com.example.parkingService.constants.vehicleTypeEnum;
import com.example.parkingService.controller.TwoWheelerParkingManager;
import com.example.parkingService.controller.TwoWheelerParkingSpot;
import com.example.parkingService.entity.MyThreadClass;
import com.example.parkingService.entity.Ticket;
import com.example.parkingService.entity.Vehicle;
import com.example.parkingService.multithreading.AddTask;
import com.example.parkingService.multithreading.ConsumeTask;
import com.example.parkingService.multithreading.SharedResource;
import com.example.parkingService.service.EntryGate;

public class ParkingServiceApplication {

	public static void main(String[] args) {
		// initalize 2 wheeler parking spot with 100 slots
		// TwoWheelerParkingSpot twoWheelerParkingSpot = new TwoWheelerParkingSpot();
		// //create a two wheeler parking manager 
		// TwoWheelerParkingManager twoWheelerParkingManager = new TwoWheelerParkingManager(100);

		// //entry gate 
		// EntryGate entryGate1 = new EntryGate();
		// Vehicle vehicle = new Vehicle(1, 007, vehicleTypeEnum.TWO_WHEELER);

		// Ticket tkt = entryGate1.parkIfPossible(vehicle,twoWheelerParkingManager);
		// System.out.println(tkt.toString());
		

		// reigster entry and exit gate
		// park a vehicle 
		// payment of a vehicle
		// exit a vehicle



		//initialize a 1d parking space for two wheeler [admin]
		//create a parking manager [admin]
		//cretae a entry gate and pass manager to it along with vehicle [admin]
		//entry gate will use manager which will use default stargety to check if slot is available [entry gate]
		//if slot is available pm will try to create a toicket  [entrygate]
		//add that car to parking spot using default stargefy [entry gate]

		
		//If car came at exit  [exit gate]
		//it shall provide the ticket []
		//based on ticket cost is calulcated using payment stargety
		//then payment is done 
		//then free up parking spot

		// System.out.println("Inside the main method "+ Thread.currentThread().getName());

		// SharedResource sharedResource = new SharedResource();

		// Thread t1 = new Thread(new AddTask(sharedResource));
		// Thread t2 = new Thread(new ConsumeTask(sharedResource));

		// t1.start();
		// t2.start();

		// 		System.out.println("Exited the main method "+ Thread.currentThread().getName());

	}

}
