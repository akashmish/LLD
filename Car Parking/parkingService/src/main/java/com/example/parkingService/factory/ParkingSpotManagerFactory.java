package com.example.parkingService.factory;

import com.example.parkingService.constants.vehicleTypeEnum;
import com.example.parkingService.controller.TwoWheelerParkingManager;
import com.example.parkingService.entity.ParkingSpotManager;
import com.example.parkingService.entity.Vehicle;

public class ParkingSpotManagerFactory {
    
    public static ParkingSpotManager getParkingSpotManager(Vehicle vehicle){
        if(vehicle.getVehicleType().equals(vehicleTypeEnum.TWO_WHEELER)){
            return null;
        }
        return null;
    }
}
