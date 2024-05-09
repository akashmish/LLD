package com.example.parkingService.multithreading;

public class ConsumeTask implements Runnable{
    
    SharedResource sharedResource;
    public ConsumeTask(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }
    @Override
    public void run(){
        System.out.println("Thread which initiated Consume method is :"+Thread.currentThread().getName());
        sharedResource.consumeItem();
    }
}
