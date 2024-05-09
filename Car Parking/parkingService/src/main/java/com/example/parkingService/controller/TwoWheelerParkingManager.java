package com.example.parkingService.controller;

import java.util.ArrayList;
import java.util.List;
import com.example.parkingService.entity.ParkingSpot;
import com.example.parkingService.entity.ParkingSpotManager;
import com.example.parkingService.entity.ParkingStrategy;
import com.example.parkingService.entity.Vehicle;

public class TwoWheelerParkingManager implements ParkingSpotManager {
    
    private ParkingStrategy twoWheelerParkingStrategy;
    private List<TwoWheelerParkingSpot> twoWheelerParkingSpace = new ArrayList<>();

    public TwoWheelerParkingManager(){    
    }

    public TwoWheelerParkingManager(Integer maxPakingSpot) {
        for(Integer i=0;i<maxPakingSpot;i++){
            twoWheelerParkingSpace.add(new TwoWheelerParkingSpot());
        }
    }

    @Override
    public TwoWheelerParkingSpot findParkingSpace(Vehicle vehicle){
        for(var it: twoWheelerParkingSpace){
            if(it.isEmpty()){
                System.out.println("Yayy spot is available");
                return it;
            }
        }
        return null;
    }

    public void parkVehicle(TwoWheelerParkingSpot twoWheelerParkingSpot,Vehicle vehicle){
        twoWheelerParkingSpot.parkVehicle(vehicle);
    }


}
