package com.phonepe.alertconfig;

import java.util.List;

import com.phonepe.exceptions.UnknownDispatchType;

public class AlertConfigItem {
    
    private String client;
    private String eventType;
    private AlertConfig alertConfig;
    private List<DispatchStrategy> dispatchStrategyList;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public AlertConfig getAlertConfig() {
        return alertConfig;
    }

    public void setAlertConfig(AlertConfig alertConfig) {
        this.alertConfig = alertConfig;
    }

    public List<DispatchStrategy> getDispatchStrategyList() {
        return dispatchStrategyList;
    }

    public void dispatchAll() throws UnknownDispatchType {
        for(DispatchStrategy dispatchStrategy: dispatchStrategyList) {
            dispatchStrategy.dispatch();
        }
    }
    
    @Override
    public String toString() {
        return "AlertConfigItem [client=" + client + ", eventType=" + eventType + ", alertConfig=" + alertConfig
                + ", dispatchStrategyList=" + dispatchStrategyList + "]";
    }

}