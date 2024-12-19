package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public abstract class Lodging {

    private String name;
    private String category;
    private String city;
    private Float rating;
    private LocalDate startDateAvailable;
    private LocalDate endDateAvailable;
    private List<Room> rooms;

    public Lodging() {
        this.rooms = new ArrayList<>();
    }

    public Lodging(String name, String category, String city, Float rating, LocalDate startDateAvailable, LocalDate endDateAvailable) {
        this.name = name;
        this.category = category;
        this.city = city;
        this.rating = rating;
        this.startDateAvailable = startDateAvailable;
        this.endDateAvailable = endDateAvailable;
        this.rooms = new ArrayList<>();
    }

    public abstract void getDetails();

    public void showRooms() {
        System.out.println("Habitaciones en " + name + ":");
        for (Room item : rooms) {
            System.out.println(item);
        }
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public LocalDate getStartDateAvailable() {
        return startDateAvailable;
    }

    public LocalDate getEndDateAvailable() {
        return endDateAvailable;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Float getRating() {
        return rating;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public String getCategory() {
        return category;
    }


    @Override
    public String toString() {
        return "Nombre: " + name + "\n" +
                "Ciudad: " + city + "\n" +
                "Calificación: " + rating + "\n";
    }

}
