package com.flipmed.Storage;

import java.util.HashMap;
import java.util.Objects;

import com.flipmed.Entity.Doctor;
import com.flipmed.Entity.Patient;

public class Storage {
    private static HashMap<String,Doctor> doctorDb;
    private static HashMap<String,Patient> patientDb;

    public static HashMap<String,Doctor> getDoctors(){
        if(Objects.isNull(doctorDb)){
            doctorDb = new HashMap<>(); 
        }
        return doctorDb;
    }

    public static HashMap<String,Patient> getPatients(){
        if(Objects.isNull(patientDb)){
            patientDb = new HashMap<>();
        }
        return patientDb;
    }
}
