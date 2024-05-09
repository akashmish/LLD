package com.example.parkingService.entity;

public interface ParkingSpot {
    
    public boolean isEmpty();
    public void parkVehicle(Vehicle vehicle);
    public void removeVehicle(Vehicle vehicle);
}
