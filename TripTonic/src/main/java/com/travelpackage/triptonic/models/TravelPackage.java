package com.travelpackage.triptonic.models;


import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
@Setter
public class TravelPackage {
    private Integer id;
    private String name;
    private Integer capacity;
    private List<Destination> destinations;
    private List<Passenger> passengers = new ArrayList<>() ;

    public TravelPackage(Integer id, String name, Integer capacity, List<Destination> destinations) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.destinations = destinations;
    }

    public void setPassengers(Passenger passengers) {
        this.passengers.add(passengers);
    }
    
    public void listAllPassengers(){
        System.out.println( "Package Name: "+this.getName()+" capacity: "+this.getCapacity()+" ,All enrolled candidates are: ");
        for(var it: this.passengers) System.out.println("Name - " +it.getName()+", "+"Number - "+ it.getPassengerNumber());
    }
}


