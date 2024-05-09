package com.flipmed;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import com.flipmed.Entity.Slot;
import com.flipmed.Entity.Type;
import com.flipmed.controller.BookingController;
import com.flipmed.controller.DoctorController;
import com.flipmed.controller.PatientController;

public class Main {
    public static void main(String[] args) throws Exception {
        //create a doctor 
        DoctorController doctorController = new DoctorController();
        PatientController patientController = new PatientController();
        BookingController bs = new BookingController(doctorController, patientController);

        Calendar cal = Calendar.getInstance();
        long today = new Date().getTime();
        long aDay = 24*3600000;
        cal.setTime(new Date(today+aDay));
        System.out.println("***********"+cal.toString());

        String pat1 = patientController.createPatient("Ankit");
        String doc1 = doctorController.createDoctor("Doci", Type.CARDIO);

        doctorController.addAvailibility(doc1,new Slot(LocalTime.of(9, 0), LocalTime.of(9, 30)));
        doctorController.addAppointment(doc1,pat1, new Slot(LocalTime.of(9, 0), LocalTime.of(9, 30)));
       
        // doctorController.showAppointments(doc1);
        bs.bookAppointment(pat1, doc1, new Slot(LocalTime.of(9, 0), LocalTime.of(10, 30)));
        // doctorController.showAppointments(doc1);
       patientController.getAllAppointents(pat1);
    }
}