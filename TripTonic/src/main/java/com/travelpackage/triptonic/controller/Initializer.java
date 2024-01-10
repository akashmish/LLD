package com.travelpackage.triptonic.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.travelpackage.triptonic.enums.PassengerType;
import com.travelpackage.triptonic.models.Activity;
import com.travelpackage.triptonic.models.ActivityImpl;
import com.travelpackage.triptonic.models.Destination;
import com.travelpackage.triptonic.models.Passenger;

public class Initializer {
    private static String[] cities = new String[]{"Poonch","MacleoadGanj","Kasol","Githari","Shimla","Ramnagr"};

    public static List<Passenger> initializePassengers(){
        List<Passenger> passengers = new ArrayList<>();

        for(int i=0;i<5;i++){
            int randAmount = (int)Math.random()*(900)+100;
            passengers.add(new Passenger("AKASH", new BigDecimal(randAmount), 01, PassengerType.STANDARD));
        }
        return passengers;
    }

    public static List<Activity> initializeActivties(){
        List<Activity> activities = new ArrayList<>();
        activities.add(new ActivityImpl("WaterSports", 1, "Water sports", new BigDecimal(100),200));
        return activities;
    }

    public static List<Destination> initializeDestinations(List<Activity> activities){
        List<Destination> destinations = new ArrayList<>();
        List<Activity> zz = new ArrayList<>();
        List<Activity> z2 = new ArrayList<>();
        List<Activity> z3 = new ArrayList<>();

        zz.add(new ActivityImpl("seaSports", 1, "Sea sports", new BigDecimal(120),100));
        z2.add(new ActivityImpl("skysports", 2, "skysports ", new BigDecimal(230),100));
        z3.add(new ActivityImpl("Paragliding", 3, "Paragliding", new BigDecimal(90),100));
        z3.add(new ActivityImpl("BungeeJump", 4, "BungeeJump", new BigDecimal(100),100));
        z3.add(new ActivityImpl("kayaking", 5, "kayaking", new BigDecimal(500),100));

            int randNumber = (int)Math.random()*(9900)+100;
        destinations.add(new Destination(cities[0],randNumber, zz));
        destinations.add(new Destination(cities[1],randNumber+10, z2));
        destinations.add(new Destination(cities[2],randNumber+40, z3));
        
        return destinations;
    }

    public static Map<Activity, Integer> initializeCapacity(List<Activity> activities) {

        Map<Activity,Integer> activityCapacity = new HashMap<>();
        for(var it: activities){
            activityCapacity.put(it, it.getCapacity());
        }
        return activityCapacity;
    }    
}
