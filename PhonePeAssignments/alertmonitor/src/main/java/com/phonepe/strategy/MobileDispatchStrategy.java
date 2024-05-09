package com.phonepe.strategy;

public class MobileDispatchStrategy implements AlertDispatcherStrategy{

    private String type;
    private String message;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String dispatch(String message) {
        this.message=message;
        return "[INFO] AlertingService: Dispatching an text on mobile"+'\n'+"[WARN] AlertingService: "+message;
    }
    
}
