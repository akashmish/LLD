public class Bill {
    Reservation reservation;
    Integer billId;
    Vehicle vehicle;
    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.billId = 1212312312;
        System.out.println("Bill Generated with Id:"+ billId);
    }

}
