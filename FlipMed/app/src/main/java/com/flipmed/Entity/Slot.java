package com.flipmed.Entity;

import java.time.LocalTime;

public class Slot {
    private LocalTime startTime;
    private LocalTime endTime;

    public Slot(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; 
        if (o == null || getClass() != o.getClass()) return false; 
        Slot slot = (Slot) o; // Cast to Slot
        return startTime.equals(slot.startTime) && endTime.equals(slot.endTime); // Compare start and end times
    }

    @Override
    public int hashCode() {
        int prime = 31; // Prime number for better hash distribution
        int result = 1;
        result = prime * result + (startTime != null ? startTime.hashCode() : 0);
        result = prime * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}