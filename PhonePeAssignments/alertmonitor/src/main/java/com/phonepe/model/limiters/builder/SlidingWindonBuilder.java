package com.phonepe.model.limiters.builder;

import com.phonepe.model.limiters.SlidingWindow;

public class SlidingWindonBuilder {
    private  long timeWindowInSeconds;
    private long bucketSize;
    private  String client;
    private  String exceptionType;

    public SlidingWindonBuilder setTimeWindowInSeconds(long timeWindowInSeconds) {
        this.timeWindowInSeconds = timeWindowInSeconds;
        return this;
    }
    public SlidingWindonBuilder setBucketSize(long bucketSize) {
        this.bucketSize = bucketSize;
        return this;
    }
    public SlidingWindonBuilder setClient(String client) {
        this.client = client;
        return this;
    }
    public SlidingWindonBuilder setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
        return this;
    }

    public SlidingWindow build(){
        return new SlidingWindow(bucketSize, timeWindowInSeconds, client, exceptionType);
    }

    

}
