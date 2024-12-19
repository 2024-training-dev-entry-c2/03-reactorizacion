package Models;

import java.util.List;

public class Hotel extends Accommodation {

    public Hotel(String city, String accommodationType, List<Room> rooms, float rating, String name, float basePrice) {
        super(city, accommodationType, rooms, rating, name);
    }

    @Override
    public void showInformation() {
        System.out.println("Nombre del Hotel: " + getName());
        System.out.println("Ciudad: " + getCity());
        System.out.println("Tipo de Instalación: " + getAccommodationType());
        System.out.println("Calificación: " + getRating() + " estrellas");
    }

    @Override
    public void updateReservations() {
        System.out.println("Updating reservations for " + getName());
    }
}