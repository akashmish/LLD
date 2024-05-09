import java.util.ArrayList;

public class Building {
    //Building will have list of floors
    ArrayList<Floor> floors = new ArrayList<>();

    Building(ArrayList<Floor> floors){
        this.floors = floors;
    }

    void addFloors(Floor newFloor){
        floors.add(newFloor);
    }

    void removeFloor(Floor remFloor){
        floors.remove(remFloor);
    }
}
