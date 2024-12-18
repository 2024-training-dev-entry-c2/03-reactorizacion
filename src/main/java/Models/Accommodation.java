package Models;

import java.time.LocalDate;
import java.util.List;

import static lib.DateUtils.*;
import static lib.RoomUtils.getSimplestRoomPrice;


public abstract class Accommodation {

    private String city;
    private String accommodationType;
    private List<Room> rooms;
    private float rating;
    private String name;
    private float basePrice;

    public Accommodation(String city, String accommodationType, List<Room> rooms, float rating, String name, float basePrice) {
        this.city = city;
        this.accommodationType = accommodationType;
        this.rooms = rooms;
        this.rating = rating;
        this.name = name;
        this.basePrice = basePrice;
    }

    public float calculateTotalPrice(LocalDate startDay, LocalDate endDay, int numberOfRooms) {
        double discountOrIncrease = 0;

        double simpleRoomPrice = getSimplestRoomPrice(rooms);

        double totalPrice = simpleRoomPrice * numberOfRooms;

        if (isLastFiveDaysOfMonth(endDay)) {
            discountOrIncrease = totalPrice * 0.15; // 15% increase
            totalPrice += discountOrIncrease;
        } else if (isWithinRange(startDay, endDay, 10, 15)) {
            discountOrIncrease = totalPrice * 0.10; // 10% increase
            totalPrice += discountOrIncrease;
        } else if (isWithinRange(startDay, endDay, 5, 10)) {
            discountOrIncrease = totalPrice * 0.08; // 8% discount
            totalPrice -= discountOrIncrease;
        }

        System.out.println("Base Price: $" + (simpleRoomPrice * numberOfRooms));
        if (discountOrIncrease > 0) {
            System.out.println("Additional Charge: $" + discountOrIncrease);
        } else if (discountOrIncrease < 0) {
            System.out.println("Discount Applied: $" + Math.abs(discountOrIncrease));
        }

        return (float) totalPrice;
    }

    public float calculateTotalPrice(LocalDate day) {
        double totalPrice = getSimplestRoomPrice(rooms);
        double discountOrIncrease = 0;

        if (isLastFiveDaysOfMonth(day)) {
            discountOrIncrease = totalPrice * 0.15; // 15% increase
            totalPrice += discountOrIncrease;
        } else if (isWithinDayRange(day, 10, 15)) {
            discountOrIncrease = totalPrice * 0.10; // 10% increase
            totalPrice += discountOrIncrease;
        } else if (isWithinDayRange(day, 5, 10)) {
            discountOrIncrease = totalPrice * 0.08; // 8% discount
            totalPrice -= discountOrIncrease;
        }

        System.out.println("Base Price: $" + getSimplestRoomPrice(rooms));
        if (discountOrIncrease > 0) {
            System.out.println("Additional Charge: $" + discountOrIncrease);
        } else if (discountOrIncrease < 0) {
            System.out.println("Discount Applied: $" + Math.abs(discountOrIncrease));
        }

        return (float) totalPrice;
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

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Float getRating() {
        return rating;
    }


    public String getName() {
        return name;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public abstract void showInformation();

    public abstract void updateReservations();
}