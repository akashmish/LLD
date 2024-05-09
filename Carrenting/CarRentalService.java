import java.util.List;

public class CarRentalService {
    
    List<Store> storeList;
    List<User> userList;
    public CarRentalService(List<Store> storeList, List<User> userList) {
        this.storeList = storeList;
        this.userList = userList;
    }

        public CarRentalService() {

    }

    public Store getStore(Location location){

        //based on location, we will filter out the Store from storeList.
        return storeList.get(0);
    }

    public void addStores(Store store){
        this.storeList.add(store);
    }


}
