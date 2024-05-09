import java.sql.*;
import java.time.Instant;

public class Reservation {
    Timestamp from;
    Timestamp to;
    Vehicle vehicle;
    Store store;
    User user;
    Integer reservationId;
    Status status;

    public Reservation() {

    }
    public Integer createReservation(User user2, Vehicle vehicle2) {
        from=Timestamp.from(Instant.now());  
        to = Timestamp.from(Instant.now());  
        vehicle = vehicle2;
        user = user2;
        status = Status.ACTIVE;
        this.reservationId = 112233;
        return reservationId;
    }

    public String endReservation() {
        return "Reservation Ended Successfully";
    }


}
