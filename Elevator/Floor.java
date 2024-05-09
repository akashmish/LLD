
public class Floor {
    int floorNumber;
    ExternalDispatcher edp;

    Floor(int n){
        this.floorNumber = n;
        edp = new ExternalDispatcher();
    }

    public void pressButton(Direction direction){
        edp.submitExternalRequest(direction,floorNumber);
    }
}
