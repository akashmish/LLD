package com.flipmed.controller;

import java.util.HashMap;

import com.flipmed.Entity.Patient;
import com.flipmed.Entity.Slot;
import com.flipmed.Storage.Storage;

public class PatientController {
    //register patient
    //view all appt
    HashMap<String,Patient> patients = Storage.getPatients();

    public String createPatient(String name){
        Patient np = new Patient(name);
        Storage.getPatients().put(np.getPatientId(),np);
        return np.getPatientId();
    }

    public boolean isSlotAvailable() {
        return true;
    }

    public void getAllAppointents(String patId){
        patients.get(patId).getAllAppointents().entrySet().stream().forEach(n->System.out.println(n.getKey().getStartTime()+" to "+n.getKey().getEndTime()+" with Mr. "+n.getValue()));
    }

}
