package com.travelpackage.triptonic.models;

import java.math.BigDecimal;

public class ActivityImpl implements Activity {
    private String activityName;
    private Integer activityId;
    private String description;
    private BigDecimal activitycost;
    private Integer capacity;

    @Override
    public String getActivityName() {
       return this.activityName;
    }
    @Override
    public Integer getActivityId() {
       return this.activityId;
    }
    @Override
    public String getDescription() {
       return this.description;
    }
    @Override
    public BigDecimal getActivitycost() {
       return this.activitycost;
    }
    @Override
    public Integer getCapacity() {
       return this.capacity;
    }

    @Override
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    
    public ActivityImpl() {
    }
    public ActivityImpl(String activityName, Integer activityId, String description, BigDecimal activitycost,
            Integer capacity) {
        this.activityName = activityName;
        this.activityId = activityId;
        this.description = description;
        this.activitycost = activitycost;
        this.capacity = capacity;
    }

}
