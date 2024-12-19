package Models;

import java.util.List;

public class Apartment extends Accommodation {

    public Apartment(String city, String accommodationType, List<Room> rooms, float rating, String name) {
        super(city, accommodationType, rooms, rating, name);
    }

    @Override
    public void showInformation() {
        System.out.println("Nombre del Apartamento: " + getName());
        System.out.println("Ciudad: " + getCity());
        System.out.println("Tipo de Instalación: " + getAccommodationType());
        System.out.println("Calificación: " + getRating() + " estrellas");
    }

    @Override
    public void updateReservations() {
        System.out.println("Updating reservations for Apartamento: " + getName());
    }
}