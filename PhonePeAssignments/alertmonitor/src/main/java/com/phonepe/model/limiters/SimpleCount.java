package com.phonepe.model.limiters;

import java.sql.Timestamp;

public class SimpleCount implements RateLimiter{
    
    private long limit;
    private final String client;
    private final String exceptionType;

    public SimpleCount(long limit,String client,String exceptionType) {
        this.limit = limit;
        this.client = client;
        this.exceptionType = exceptionType;
        printHeader(client,exceptionType);
    }

    private void printHeader(String client, String exceptionType) {
        System.out.println("[INFO] MonitoringService: Client "+ this.client +
        this.exceptionType+" SIMPLE_COUNT started at "+
        new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public synchronized boolean allow() {
        limit--;
        if(limit<0){
            return false;
        }
        return true;
      }

}
