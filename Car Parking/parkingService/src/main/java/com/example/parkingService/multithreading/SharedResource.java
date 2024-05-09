package com.example.parkingService.multithreading;

public class SharedResource {
    public boolean isAvailable = false;
    
    public synchronized void addItem(){
        isAvailable = true;
        System.out.println("Availibilty is added by "+Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("consumeItem() methos invoked by htread"+ Thread.currentThread().getName());
        while(!isAvailable){
            try {
                System.out.println("waiting "+Thread.currentThread().getName());
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("Item Consumed by "+Thread.currentThread().getName());
        isAvailable = false;
    }
}
