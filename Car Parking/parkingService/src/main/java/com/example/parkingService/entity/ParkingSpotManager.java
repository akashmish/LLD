package com.example.parkingService.entity;

import com.example.parkingService.controller.TwoWheelerParkingSpot;

public interface ParkingSpotManager {
   public TwoWheelerParkingSpot findParkingSpace(Vehicle vehicle);
    // void addParkingSpace(Integer row,Integer );
    // void removeParkingSpace(Vehicle vehicle);

}
