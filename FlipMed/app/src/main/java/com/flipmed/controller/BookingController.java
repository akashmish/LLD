package com.flipmed.controller;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

import com.flipmed.Entity.Slot;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookingController {

    
    //make a booking
    //book
    //cancel
    private final DoctorController doctorController;
    private final PatientController patientController;

    public String bookAppointment(String patId,String docId,Slot slot) throws Exception{
        //check if doctors slot is empty
        //check if user has booken any doctor in this slot
        //otherwise just book
        //poot a booking in doctors hashset and one in cystomer
        ReentrantLock lock = new ReentrantLock();
        ReadWriteLock lock2 = new ReentrantReadWriteLock();
        StampedLock lock3 =new  StampedLock();
        long stamp = lock3.writeLock();
        Semaphore sem = new Semaphore(5);
        
        Thread th  = new Thread(()-> {
            try {
                sem.acquire();
                System.out.println("Run");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                sem.release();
            }
        });

        lock3.validate(stamp);
        

        if(doctorController.isSlotAvaible(docId, slot) && patientController.isSlotAvailable()){
            doctorController.addAppointment(docId, patId, slot);
            return "Booked Successfully";
        }else{
            return "Slots not free";
        }
    }
    

}
