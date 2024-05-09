package com.example.parkingService.multithreading;

public class AddTask implements Runnable{
    
    SharedResource sharedResource;
    public AddTask(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run(){
        System.out.println("Thread which initiated add method is :"+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        sharedResource.addItem();
    }
}
