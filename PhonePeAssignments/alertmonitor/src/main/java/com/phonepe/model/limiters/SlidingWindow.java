package com.phonepe.model.limiters;

import java.sql.Timestamp;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindow implements RateLimiter{
    private Queue<Long> queue;
    private  long timeWindowInSeconds;
    private long bucketSize;
    private final String client;
    private final String exceptionType;


    public SlidingWindow(long bucketSize, long timeWindowInSeconds,String client,String exceptionType) {
        this.timeWindowInSeconds = timeWindowInSeconds;
        this.bucketSize = bucketSize;
        this.queue = new ConcurrentLinkedQueue<Long>();
        this.client = client;
        this.exceptionType = exceptionType;
        printHeader(client,exceptionType);
    }

    @Override
    public synchronized boolean allow() {
        Long currentTime = System.currentTimeMillis();
        checkAndUpdateWindow(currentTime);
        if(queue.size() < bucketSize){
            queue.offer(currentTime);
            return true;
        }
        return false;
    }
    
    public void checkAndUpdateWindow(Long currentTime){
        if(queue.isEmpty()) return;
        long time = (currentTime - queue.peek())/1000;
        while (!queue.isEmpty() && time >= timeWindowInSeconds){
            queue.poll();
            if(!queue.isEmpty()) time = (currentTime - queue.peek())/1000;
        }
    }

    private void printHeader(String client,String exceptionType) {
        System.out.println('\n'+"[INFO] MonitoringService: Client "+this.client+" "+ this.exceptionType+
                " SLIDING_WINDOW starts at "+
                new Timestamp(System.currentTimeMillis())+'\n');
    }

}
