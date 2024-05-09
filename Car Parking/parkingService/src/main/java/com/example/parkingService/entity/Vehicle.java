package com.example.parkingService.entity;

public class Vehicle {
    private Integer id;
    private Integer vehicleNumber;
    private Enum vehicleType;
    public Integer getId() {
        return id;
    }

    public Vehicle(Integer id, Integer vehicleNumber, Enum vehicleType) {
        this.id = id;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public Integer getVehicleNumber() {
        return vehicleNumber;
    }

    public Enum getVehicleType() {
        return vehicleType;
    }


}
