package com.example.parkingService.service;

import java.util.List;

import com.example.parkingService.entity.ParkingSpot;
import com.example.parkingService.entity.ParkingStrategy;

public class DefaultParkingStrategy implements ParkingStrategy{
    
    

    @Override
    public ParkingSpot findFreeParking(List<ParkingSpot> list){
        for(var it: list){
            if(it.isEmpty()==true) return it;
        }
        return null;
    }
}
