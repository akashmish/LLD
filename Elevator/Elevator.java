public class Elevator {
    int currentFloor;
    Direction direction;
    InternalButton internalButton;
    Status status;
    Integer id;
    ElevatorDisplay elevatorDisplay;

    Elevator(){
        elevatorDisplay = new ElevatorDisplay();
        internalButton = new InternalButton();
        currentFloor=0;
        direction = Direction.UP;
        status = Status.GOING_UP;
    }

    public void showdisplay(){
        elevatorDisplay.showdisplay();
    }

    public void pressButton(int destination){
        internalButton.pressButton(destination,this);
    }

    public void setDisplay(){
        elevatorDisplay.setDisplay();
    }

    //move elevator
}
