package com.flipmed.Entity;

import java.util.*;

import lombok.Data;

@Data
public class Patient {
    private String name;
    private String patientId;
    HashMap<Slot,String> myBookings;

    public Patient(String name) {
        this.name = name;
        this.patientId = UUID.randomUUID().toString().replaceAll("-","");
        this.myBookings = new HashMap<>();
    }

    public HashMap<Slot,String>  getAllAppointents(){
        return this.myBookings;
    }

}
