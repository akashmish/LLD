package com.example.parkingService.entity;

import java.util.List;

public interface ParkingStrategy {
    public ParkingSpot findFreeParking(List<ParkingSpot> list);
}
