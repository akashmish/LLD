package com.phonepe.model.limiters.builder;

import com.phonepe.model.limiters.SimpleCount;

public class SimpleCountBuilder {
    private long limit;
    private String client;
    private String exceptionType;

    public SimpleCountBuilder setLimit(long limit) {
        this.limit = limit;
        return this;
    }

    public SimpleCountBuilder setClient(String client) {
        this.client = client;
        return this;
    }

    public SimpleCountBuilder setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
        return this;
    }

    public SimpleCount build(){
        return new SimpleCount(limit, client, exceptionType);
    }




    
}
