public class Initialization {
    Store store;
    Vehicle vehicle;
    User user;
    VehicleInventoryManager uim;

    public Initialization(){
    }

    public static void addVehicles(VehicleInventoryManager uim){
        Vehicle vehicle1 = new Vehicle("UP32NNM23", 12);
        Vehicle vehicle2 = new Vehicle("UP32BT2223", 13);
        Vehicle vehicle3 = new Vehicle("UP32UJ8765", 42);
        Vehicle vehicle4 = new Vehicle("UP3ZZM2123", 52);
        uim.addVehicle(vehicle4);
        uim.addVehicle(vehicle3);
        uim.addVehicle(vehicle3);
        uim.addVehicle(vehicle1);
    }

    public static void addStores(CarRentalService carRentalService,VehicleInventoryManager vim){
        Store store1= new Store(new Location("Lucknow","Hazratganj", 226622),112233,vim);
        Store store2= new Store(new Location("Agra","Pantnagar", 23423444),1123,vim);
        Store store3= new Store(new Location("Bangalore","Marathalli", 345533),12312,vim);
        // carRentalService.
    }
}
