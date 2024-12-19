package Models;

import java.time.LocalDate;
import java.util.List;

import static lib.DateUtils.*;
import static lib.RoomUtils.getSimplestRoom;

public abstract class Accommodation {

    private String city;
    private String accommodationType;
    protected List<Room> rooms;
    protected List<Reservation> reservations;
    private Float rating;
    private String name;

    public Accommodation(String city, String accommodationType, List<Room> rooms, Float rating, String name, List<Reservation> reservations) {
        this.city = city;
        this.accommodationType = accommodationType;
        this.rooms = rooms;
        this.rating = rating;
        this.reservations = reservations;
        this.name = name;
    }

    public Room calculateBasePrice() {
        return getSimplestRoom(rooms);
    }

    private Double applyLastFiveDaysIncrease(Double totalPrice) {
        return totalPrice * 0.15;
    }

    private Double applyMidMonthIncrease(Double totalPrice) {
        return totalPrice * 0.10;
    }

    private Double applyEarlyMonthDiscount(Double totalPrice) {
        return totalPrice * 0.08;
    }

    public Double calculateTotalPrice(LocalDate startDay, LocalDate endDay, Integer numberOfRooms) {
        Double totalPrice = calculateBasePrice().getBasePrice() * numberOfRooms *
                (endDay.getDayOfMonth() - startDay.getDayOfMonth());

        if (isLastFiveDaysOfMonth(endDay)) {
            totalPrice += applyLastFiveDaysIncrease(totalPrice);
        } else if (isWithinRange(startDay, endDay, 10, 15)) {
            totalPrice += applyMidMonthIncrease(totalPrice);
        } else if (isWithinRange(startDay, endDay, 5, 10)) {
            totalPrice -= applyEarlyMonthDiscount(totalPrice);
        }

        return totalPrice;
    }


    public String getCity() {
        return city;
    }

    public String getAccommodationType() {
        return accommodationType;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Float getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacityAdults() {
        return getSimplestRoom(rooms).getCapacityAdults();
    }

    public Integer getCapacityChildren() {
        return getSimplestRoom(rooms).getCapacityMinors();
    }

    public abstract void showInformation();

}