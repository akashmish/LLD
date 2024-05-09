package com.phonepe.strategy;

public class EmailDispatcherStrategy implements AlertDispatcherStrategy{

    private String type;
    private String message;

    public EmailDispatcherStrategy() {
        this.type = "EMAIL";
    }

    @Override
    public String dispatch(String message) {
        this.message=message;
        return "[INFO] AlertingService: Dispatching an email"+'\n'+"[WARN] AlertingService: "+message;
    }

    @Override
    public String toString() {
        return "EmailDispatcherStrategy [type=" + type + ", message=" + message + "]";
    }
    
}
