import java.util.ArrayList;
import java.util.List;

public class Store {
    VehicleInventoryManager vehicleInventoryManager;
    Location storeLocation;
    ArrayList<Reservation> totReserv = new ArrayList<>();
    Integer storeId;

    //crud on vehicles
    //get vehicles
    //set vehicles or add
    //makr a reservation
    //complete a reservation

    public Location getStoreLocation() {
        return storeLocation;
    }

    public Store(Location storeLocation, Integer storeId,VehicleInventoryManager vehicleInventoryManager) {
        this.storeLocation = storeLocation;
        this.storeId = storeId;
        this.vehicleInventoryManager = vehicleInventoryManager;
    }

    public void setStoreLocation(Location storeLocation) {
        this.storeLocation = storeLocation;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public List<Vehicle> getVehicle(Store this,VehicleType vehicleType){
        return vehicleInventoryManager.getVehicle(this,vehicleType);
    }

    public List<Vehicle> getVehicle(){
        return vehicleInventoryManager.getVehicle();
    }

    public void addVehicle(Vehicle vehicle){
        vehicleInventoryManager.addVehicle(vehicle);
    }

    public Reservation makeReservation(Vehicle vehicle,User user){
        System.out.println("Making reservation for vehicle "+vehicle.VehicleNumber+" User: "+user.name);
        Reservation reservation = new Reservation();
        reservation.createReservation(user,vehicle);
        totReserv.add(reservation);
        System.out.println("Reservation Done now proceeding to booking");
        return reservation;
    }
    
    public String completeReservation(Reservation completedReservation){
        return completedReservation.endReservation();
        
    }
}
