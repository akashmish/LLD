package com.example.parkingService.service;

import java.sql.Timestamp;
import java.util.UUID;

import com.example.parkingService.controller.TwoWheelerParkingManager;
import com.example.parkingService.controller.TwoWheelerParkingSpot;
import com.example.parkingService.entity.ParkingSpot;
import com.example.parkingService.entity.ParkingSpotManager;
import com.example.parkingService.entity.Ticket;
import com.example.parkingService.entity.Vehicle;

public class EntryGate {


    public Ticket parkIfPossible(Vehicle vehicle, TwoWheelerParkingManager parkingSpotManager){
        TwoWheelerParkingSpot ps = parkingSpotManager.findParkingSpace(vehicle);
        if(ps!=null){
            System.out.println("ticket is being created");
            //create a ticket
            parkingSpotManager.parkVehicle(ps, vehicle);
            System.out.println("Vehicle parked "+ps.toString());
            return new Ticket(new Timestamp(System.currentTimeMillis()),vehicle);
        }else{
            System.out.println("NO SPace available");
        }
        //check if parking is possible
        //1. find if parking space is empty
        //2. if yes create a tiket
        return null;
    }
}
