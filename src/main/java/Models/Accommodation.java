package Models;

import lib.PricingStrategy;

import java.time.LocalDate;
import java.util.List;

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

    public Double calculateTotalPrice(LocalDate startDay, LocalDate endDay, Integer numberOfRooms) {
        Double basePrice = calculateBasePrice().getBasePrice();
        return PricingStrategy.calculateTotalPrice(basePrice, startDay, endDay, numberOfRooms);
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
