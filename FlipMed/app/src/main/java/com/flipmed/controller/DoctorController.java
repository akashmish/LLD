package com.flipmed.controller;

import java.util.*;

import com.flipmed.Entity.Doctor;
import com.flipmed.Entity.Slot;
import com.flipmed.Entity.Type;
import com.flipmed.Storage.Storage;

public class DoctorController {
    //create doctor
    Doctor doctor;
    private final HashMap<String,Doctor> doctors = Storage.getDoctors();

    public String createDoctor(String name,Type doctorType){
        Doctor newDoc = new Doctor(name, doctorType);
        doctors.put(newDoc.getDocId(),newDoc);
        return newDoc.getDocId();
    }

    public void addAvailibility(String docId,Slot availableSlot) throws Exception{
            if(Storage.getDoctors().get(docId)!=null){
                Storage.getDoctors().get(docId).addslot(availableSlot);
            }else{
                throw new Exception("No doctor found");
            }
    }

    public void showAppointments(String docId) throws Exception{
        if(Storage.getDoctors().get(docId)!=null){
            HashMap<Slot,String> apps = Storage.getDoctors().get(docId).getAppointments();
            apps.entrySet().stream().forEach(n->System.out.println(n.getKey().getStartTime()+" to "+n.getKey().getEndTime()+" with Mr. "+n.getValue()));
        }else{
            throw new Exception("No doctor found");
        }
    }

    public void addAppointment(String docId,String patientId,Slot slot) throws Exception{
        if(Storage.getDoctors().get(docId)!=null){
            Storage.getDoctors().get(docId).addAppointment(slot,patientId);
        }else{
            throw new Exception("No doctor found");
        }
    }

    public boolean isSlotAvaible(String docId,Slot slot) throws Exception{
        if(Storage.getDoctors().get(docId)!=null){
           return Storage.getDoctors().get(docId).isSlotAvaible(slot);
        }else{
            throw new Exception("No doctor found");
        }
    }
}
