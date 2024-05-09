package com.flipmed.Entity;

import java.util.*;

import lombok.Data;

@Data
public class Doctor {
    private String name;
    private String docId;
    private Type docType;
    HashSet<Slot> availaSlots;
    HashMap<Slot,String> appointments;

    HashSet<Slot> availableSlots;

    public Doctor(String name, Type docType) {
        this.name = name;
        this.docType = docType;
        this.docId = UUID.randomUUID().toString().replaceAll("-", "");
        this.availaSlots = new HashSet<>();
        this.appointments = new HashMap<>();
    }

    public void addslot(Slot slot){
        this.availaSlots.add(slot);
    }

    public HashMap<Slot,String> showAppointments(){
        return this.appointments;
    }

    public void addAppointment(Slot slot, String patientId) {
       this.appointments.put(slot, patientId);
    }

    public boolean isSlotAvaible(Slot slot) {
        if(availaSlots.contains(slot)){
            System.out.println("Slot already taken");
            return false;
        }else{
            return true;
        }
    }
    
}
