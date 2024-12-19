package org.example;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public class BookingData {

    User user;
    Lodging lodging;
    private String estimatedArrivalTime;
    private Integer numberOfRoomsForBooking;

    public BookingData(User user, Lodging lodging, String estimatedArrivalTime, Integer numberOfRoomsForBooking) {
        this.user = user;
        this.lodging = lodging;
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.numberOfRoomsForBooking = numberOfRoomsForBooking;
    }

    public BookingData() {}

    public User getUser() {
        return user;
    }

    public Lodging getLodging() {
        return lodging;
    }

    public void setLodging(Lodging lodging) {
        this.lodging = lodging;
    }

    public String getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }


    public Integer getNumberOfRoomsForBooking() {
        return numberOfRoomsForBooking;
    }

    public void setNumberOfRoomsForBooking(Integer numberOfRoomsForBooking) {
        this.numberOfRoomsForBooking = numberOfRoomsForBooking;
    }
}
