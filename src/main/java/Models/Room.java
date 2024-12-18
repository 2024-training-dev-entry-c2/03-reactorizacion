package Models;

import java.time.LocalDate;
import java.util.Set;

public class Room {
    private String description;
    private String roomType;
    private float basePrice;
    private int capacityMinors;
    private int capacityAdults;
    private Set<LocalDate> availability;

    public Room(String description, String roomType, float basePrice, int capacityMinors, int capacityAdults, Set<LocalDate> availability) {
        this.description = description;
        this.roomType = roomType;
        this.basePrice = basePrice;
        this.capacityMinors = capacityMinors;
        this.capacityAdults = capacityAdults;
        this.availability = availability;
    }

    public void showInformation() {
        System.out.println("- Tipo de Habitación: " + roomType);
        System.out.println("Descripción: " + description);
        System.out.println("Precio Base: $" + basePrice);
        System.out.println("Capacidad para Menores: " + capacityMinors);
        System.out.println("Capacidad para Adultos: " + capacityAdults);
    }

    public void obtenerDisponibilidad() {
        if (availability.isEmpty()) {
            System.out.println("No hay fechas disponibles.");
        } else {
            System.out.println("Fechas disponibles:");
            for (LocalDate date : availability) {
                System.out.println(date);
            }
        }
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


    public float getBasePrice() {
        return basePrice;
    }


    public int getCapacityMinors() {
        return capacityMinors;
    }

    public int getCapacityAdults() {
        return capacityAdults;
    }

    public Set<LocalDate> getAvailability() {
        return availability;
    }

    public void setAvailability(Set<LocalDate> availability) {
        this.availability = availability;
    }
}