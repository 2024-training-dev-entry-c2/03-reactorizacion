package Models;

import java.time.LocalDate;
import java.util.Set;

public class Room {
    private String description;
    private String roomType;
    private double basePrice;
    private int capacityMinors;
    private int capacityAdults;
    private int amountRooms;
    private Set<LocalDate> availability;

    public Room(String description, String roomType, double basePrice, int capacityMinors, int capacityAdults, int amountRooms, Set<LocalDate> availability) {
        this.description = description;
        this.roomType = roomType;
        this.basePrice = basePrice;
        this.capacityMinors = capacityMinors;
        this.capacityAdults = capacityAdults;
        this.amountRooms = amountRooms;
        this.availability = availability;
    }

    public void showInformation() {
        System.out.println("- Tipo de Habitación: " + roomType);
        System.out.println("Descripción: " + description);
        System.out.println("Precio Base: $" + basePrice);
        System.out.println("Capacidad para Menores: " + capacityMinors);
        System.out.println("Capacidad para Adultos: " + capacityAdults);
    }

    public boolean isAvailableOn(LocalDate date) {
        return availability.contains(date);
    }

    public String getDescription() {
        return description;
    }


    public String getRoomType() {
        return roomType;
    }


    public double getBasePrice() {
        return basePrice;
    }


    public int getCapacityMinors() {
        return capacityMinors;
    }

    public int getCapacityAdults() {
        return capacityAdults;
    }

    public int getAmountRooms() {
        return amountRooms;
    }

    public void setAmountRooms(int amountRooms) {
        this.amountRooms = amountRooms;
    }

    public boolean getAvailability() {
        return amountRooms>  0;
    }

    public void setAvailability(Set<LocalDate> availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Habitación{" +
                "descripción='" + description + '\'' +
                ", tipo='" + roomType + '\'' +
                ", precio base=" + basePrice +
                ", capacidad menores=" + capacityMinors +
                ", capacidad mayores=" + capacityAdults +
                '}';
    }
}