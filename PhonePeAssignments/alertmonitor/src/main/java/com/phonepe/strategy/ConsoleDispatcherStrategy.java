package com.phonepe.strategy;

public class ConsoleDispatcherStrategy implements AlertDispatcherStrategy{

    private String type;
    private String message;

    public ConsoleDispatcherStrategy() {
        this.type = "CONSOLE";
    }

    @Override
    public String dispatch(String message) {
        this.message=message;
        return "[INFO] AlertingService: Dispatching to Console"+'\n'+"[WARN] AlertingService: "+message;

    }

    @Override
    public String toString() {
        return "ConsoleDispatcherStrategy [type=" + type + ", message=" + message + "]";
    }
    
}
