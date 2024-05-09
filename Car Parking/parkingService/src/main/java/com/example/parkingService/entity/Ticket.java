package com.example.parkingService.entity;

import java.sql.*;
import java.util.UUID;

public class Ticket {
    private Timestamp curTime;
    private Vehicle vehicle;
    String ticketId;

    

    public Ticket(Timestamp curTime, Vehicle vehicle) {
        this.curTime = curTime;
        this.vehicle = vehicle;
        this.ticketId =  UUID.randomUUID().toString();
    }
    public Timestamp getCurTime() {
        return curTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    @Override
    public String toString() {
        return "Ticket [curTime=" + curTime + ", vehicle=" + vehicle + ", ticketId=" + ticketId + "]";
    }

}
