package Models;

import java.time.LocalDate;
import java.util.Set;

public class Room {
    private String description;
    private String roomType;
    private Double basePrice;
    private Integer capacityMinors;
    private Integer capacityAdults;
    private Integer amountRooms;

    public Room(String description, String roomType, Double basePrice, Integer capacityMinors, Integer capacityAdults, Integer amountRooms, Set<LocalDate> availability) {
        this.description = description;
        this.roomType = roomType;
        this.basePrice = basePrice;
        this.capacityMinors = capacityMinors;
        this.capacityAdults = capacityAdults;
        this.amountRooms = amountRooms;
    }

    public Room(){

    }

    public Boolean isAvailable() {
        return amountRooms>  0;
    }

    public String getDescription() {
        return description;
    }

    public String getRoomType() {
        return roomType;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public Integer getCapacityMinors() {
        return capacityMinors;
    }

    public Integer getCapacityAdults() {
        return capacityAdults;
    }

    public Integer getAmountRooms() {
        return amountRooms;
    }

    public void setAmountRooms(Integer amountRooms) {
        this.amountRooms = amountRooms;
    }

    @Override
    public String toString() {
        return String.format(
                "Habitación{tipo='%s', descripción='%s', precio base=%.2f, capacidad menores=%d, capacidad adultos=%d, cantidad habitaciones=%d}",
                roomType, description, basePrice, capacityMinors, capacityAdults, amountRooms
        );
    }
}