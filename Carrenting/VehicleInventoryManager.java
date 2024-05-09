import java.util.ArrayList;
import java.util.List;

public class VehicleInventoryManager {
    List<Vehicle> vehicles =  new ArrayList<>();

    

    public VehicleInventoryManager() {
        // this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicle(Store store, VehicleType vehicleType) {
        return vehicles;
    }

    public List<Vehicle> getVehicle() {
        return vehicles;
    }
    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

}
