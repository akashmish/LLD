package com.travelpackage.triptonic.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.travelpackage.triptonic.models.Activity;
import com.travelpackage.triptonic.models.Destination;
import com.travelpackage.triptonic.models.Passenger;
import com.travelpackage.triptonic.models.Reservation;
import com.travelpackage.triptonic.models.TravelPackage;

public class TravelPackageManager {

    private List<Passenger> passengersList = new ArrayList<>();
    private List<TravelPackage> travelPackages = new ArrayList<>();
    private List<Activity> activities= new ArrayList<>();
    private List<Destination> destinations= new ArrayList<>();
    private TravelPackage travelPackage;
    private Map<Passenger,Reservation> passengerReservationMap = new HashMap();
    private Map<Activity,Integer> activityCapacity = new HashMap<>();
    private Map<Activity,Destination> activityDesination  = new HashMap<>();
    private Map<Destination,List<Activity>> destActi = new HashMap<>();

    public TravelPackageManager(){
        this.passengersList = Initializer.initializePassengers();
        this.activities = Initializer.initializeActivties();
        this.destinations = Initializer.initializeDestinations(this.activities);
        this.activityCapacity = Initializer.initializeCapacity(activities);
        this.travelPackage = new TravelPackage();
        addPackage();
    }

    public void addPackage(){
        this.travelPackages.add(new TravelPackage(1, "Manali Package", 300, this.destinations));
    }

    public void listPackages() {
        for(var it:this.travelPackages) System.out.println( it.toString());
       
    }

    public List<Passenger> getPassenegrs() {
        List<Passenger> passengersList = new ArrayList<>();
         passengersList = this.passengersList;
         return passengersList;
    }

    public Reservation bookPackage(Passenger demoPassenger, int packageId, int[] activties) {
        TravelPackage requestedPackage = getPackageById(packageId);
        List<Activity> availableActivities = new ArrayList<>();
        Reservation reservation = null;
        BigDecimal cost = new BigDecimal(0);
        if(requestedPackage!=null || requestedPackage.getCapacity()>0){
            for(var it: requestedPackage.getDestinations()){
                for(var acties: it.getAvailableActivties()){
                    for(int i=0;i<activties.length;i++){
                        if(activties[i]==acties.getActivityId()){
                            System.out.println("Found this activity "+ acties.getActivityName()+" with id: "+ acties.getActivityId()+" in destination "+it);
                            availableActivities.add(acties);
                            cost=cost.add(acties.getActivitycost());
                        }
                    }
                }
            }
        }else{
            throw new RuntimeException("Invalid packageId");
        }

        if(availableActivities.size()>0){
            //create areservation 
            reservation = new Reservation(requestedPackage, availableActivities, cost,demoPassenger);
            System.out.println("reservation creted with "+reservation.getReservationId()+" "+reservation.getTotCost()+" If you wish to proceed go for payment" );
        }else{
            System.out.println("Sorry No activties are available which you selected");
        }
        return reservation;
    }

    private TravelPackage getPackageById(int packageId) {
        for(var it: this.travelPackages){
            if(it.getId()==packageId) return it;
        }
        return null;
    }

    public void completeReservation(Reservation reservationDetails) {
        TravelPackage packageSelected = reservationDetails.getTravelPackage();
        List<Activity> activitiesSelected = reservationDetails.getActivtiesSelected();
        Passenger passenger = reservationDetails.getDemoPassenger();
        BigDecimal initialAmount = passenger.getBalance();
        packageSelected.setPassengers(passenger);
        packageSelected.setCapacity(packageSelected.getCapacity()-1);
        for(var it: activitiesSelected){
           it.setCapacity(it.getCapacity()-1); 
           this.activityCapacity.put(it,it.getCapacity());
        } 
        passenger.setBalance(initialAmount.subtract(reservationDetails.getTotCost()));
        passengerReservationMap.put(passenger, reservationDetails); 
    }

    public void listPackageDetails(Integer id) {
        TravelPackage newPack = getPackageById(id);
        newPack.listAllPassengers();
    }

    public void printPassengerDetails() {
        List<Passenger> passengerList = this.passengersList;
        //map of passenger vs reservation Id
        for(Passenger it: passengerList){
            if(passengerReservationMap.containsKey(it)){
                printReservationDetails(passengerReservationMap.get(it));
            }else{
                System.out.println("User: "+it.getName()+" does not have any bookings");
            }
        }
    }

    private void printReservationDetails(Reservation reservationDetails) {
        TravelPackage packageSelected = reservationDetails.getTravelPackage();
        List<Activity> activitiesSelected = reservationDetails.getActivtiesSelected();
        Passenger passenger = reservationDetails.getDemoPassenger();
        System.out.println("Passenger Name : "+passenger.getName());
        System.out.println("Passenger Number : "+passenger.getPassengerNumber());
        System.out.println("Passenger Type : "+passenger.getType());
        if(!passenger.getType().equals("GOLD")){
            System.out.println("Passenger Amount  : "+passenger.getBalance());
        }

        System.out.println("Package selected by "+passenger.getName()+" ,is "+packageSelected.getName());
        System.out.println("All Activties selected are listed below : ");
        for(var it: activitiesSelected){
            System.out.println("Activity name: "+ it.getActivityName()+", Activity destination: ?? "+", Cost : "+it.getActivitycost());
        }
    }

    public void listAvailableSpots() {
        for(Map.Entry<Activity,Integer> it: activityCapacity.entrySet()){
            System.out.println(it.getKey().getActivityName()+" has "+it.getValue());
        }
    }

}
