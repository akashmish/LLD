import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args){
        System.out.println("inside the main class");

        //create a store
        //create a vehicle
        //add vehicle to store 
        //create a user 
        //list all vehicles
        //select one vehicle from that 
        //make reservations

        //Created a VehicleInventoryManager
        VehicleInventoryManager vim = new VehicleInventoryManager();
        CarRentalService carRentalService = new CarRentalService();

        Initialization.addVehicles(vim);
        Initialization.addStores(carRentalService,vim);


        User newUser = new User("AKASH", 1122);
        for(var it: vim.vehicles){
            System.out.println(it.VehicleNumber);
        }
        List<Vehicle> getAllVehicles = store.getVehicle();
        Reservation reservation = store.makeReservation(getAllVehicles.get(0),newUser);
        //generate the bill
        Bill bill =  new Bill(reservation);

        //makePayment
        Payment payment = new Payment();
        payment.completePayment(bill);

        // store.completeReservation(reservation);



        // List<User> users = addUsers();
        // List<Vehicle> vehicles = addVehicles();
        // List<Store> stores = addStores(vehicles);
        // CarRentalService rentalSystem = new CarRentalService(stores,users);

        // User user = users.get(0);
        // System.out.println("Selected user as : "+user.getName());

        // Store store = stores.get(0);
        // System.out.println("Selected store as :"+store);

        // // List<Vehicle> allVehicles = store.getVehicle(VehicleType.SEDAN);

        // //make a reservation
        // System.out.println("Going to make a reservation with car : "+vehicles.get(0));
        // Reservation reservation = store.makeReservation(vehicles.get(0), user);
        // //generate the bill
        // Bill bill =  new Bill(reservation);
        // //makePayment
        // Payment payment = new Payment();
        // payment.completePayment(bill);

        // store.completeReservation(reservation);
    }

    // private static List<User> addUsers() {
    //     List<User> users1 = new ArrayList<>();
    //     User user1 = new User("AKASH", 1);
    //     users1.add(user1);
    //     return users1;
    // }

    // private static List<Vehicle> addVehicles() {
    //     List<Vehicle> vehicles = new ArrayList<>();
    //     Vehicle vehicle1 = new Vehicle("up32", 1);
    //     Vehicle vehicle2 = new Vehicle("up33", 2);
    //     vehicles.add(vehicle1);
    //     vehicles.add(vehicle2);
    //     return vehicles;
    // }

    // private static List<Store> addStores(List<Vehicle> vehicles) {
    //     List<Store> stores = new ArrayList<>();
    //     Store store1 = new Store();
    //     System.out.println(vehicles);
    //     // store1.addVehicle(vehicles);
    //     stores.add(store1);
    //     return stores;
    // }
}
