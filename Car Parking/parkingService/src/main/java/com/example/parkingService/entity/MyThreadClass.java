package com.example.parkingService.entity;

public class MyThreadClass implements Runnable{
    
    @Override
    public void run(){
        System.out.println("This is inside the class "+ Thread.currentThread().getName());
    }
}
