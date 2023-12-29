package com.travelpackage.triptonic.models;

import java.math.BigDecimal;

public interface Activity {

    String getActivityName();

    Integer getActivityId();

    String getDescription();

    BigDecimal getActivitycost();

    Integer getCapacity();

    void setCapacity(Integer capacity);

    java.lang.String toString();

}