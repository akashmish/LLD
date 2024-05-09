package com.phonepe.alertconfig;

import com.phonepe.exceptions.UnknownDispatchType;
import com.phonepe.strategy.AlertDispatcherStrategy;
import com.phonepe.strategy.ConsoleDispatcherStrategy;
import com.phonepe.strategy.EmailDispatcherStrategy;
import com.phonepe.strategy.MobileDispatchStrategy;

public class DispatchStrategy {
    
    private String type;
    private String message;

    private final AlertDispatcherStrategy emailDispatcherStrategy= new EmailDispatcherStrategy();
    private final AlertDispatcherStrategy consoleDispatcherStrategy= new ConsoleDispatcherStrategy();
    private final MobileDispatchStrategy mobileDispatchStrategy = new MobileDispatchStrategy();

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

    public String dispatch() throws UnknownDispatchType {
        String debugText = null;
        if(type.equals("CONSOLE")) {
            debugText = consoleDispatcherStrategy.dispatch(message);
        }
        else if(type.equals("EMAIL")) {
           debugText = emailDispatcherStrategy.dispatch(message);
        }else if(type.equals("MOBILE")){
            debugText = mobileDispatchStrategy.dispatch(message);
        }else{
            throw new UnknownDispatchType("Please Enter a valid Dispatch type");
        }
        return debugText;
    }

    @Override
    public String toString() {
        return "DispatchStrategy [type=" + type + ", message=" + message + ", emailDispatcherStrategy="
                + emailDispatcherStrategy + ", consoleDispatcherStrategy=" + consoleDispatcherStrategy + "]";
    }

    
}
