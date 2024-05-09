public class Vehicle {
    String VehicleNumber;
    Integer VehicleId;
    Status vehicleStatus;
    
    public Vehicle(String vehicleNumber, Integer vehicleId) {
        VehicleNumber = vehicleNumber;
        VehicleId = vehicleId;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }
    public Integer getVehicleId() {
        return VehicleId;
    }
    public void setVehicleId(Integer vehicleId) {
        VehicleId = vehicleId;
    }
    public Status getVehicleStatus() {
        return vehicleStatus;
    }
    public void setVehicleStatus(Status vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

}
