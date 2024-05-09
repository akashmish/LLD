package com.flipmed.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Appointment {
    String appointmentId;
    String docId;
    String patId;
    Slot slot;
}
