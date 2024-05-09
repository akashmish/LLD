package com.example.parkingService.controller;

import com.example.parkingService.entity.ParkingSpot;
import com.example.parkingService.entity.Vehicle;
import java.util.*;

public class TwoWheelerParkingSpot implements ParkingSpot{
    
    private Vehicle parkedVehicle;
    private boolean isEmpty; 

    @Override
    public boolean isEmpty(){
        return isEmpty;
    }

    public TwoWheelerParkingSpot() {
        this.isEmpty = true;
    }

    @Override
    public void parkVehicle(Vehicle vehicle){
        parkedVehicle = vehicle;
        isEmpty = false;
    }

    @Override
    public void removeVehicle(Vehicle vehicle){
        parkedVehicle = null;
        isEmpty=true;
    }

    @Override
    public String toString() {
        return "TwoWheelerParkingSpot [parkedVehicle=" + parkedVehicle + ", isEmpty=" + isEmpty + "]";
    }

}
