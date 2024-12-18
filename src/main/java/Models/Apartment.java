package Models;

import java.util.List;

public class Apartment extends Accommodation {

    public Apartment(String city, String accommodationType, List<Room> rooms, float rating, String name, float basePrice) {
        super(city, accommodationType, rooms, rating, name, basePrice);
    }

    @Override
    public void showInformation() {
        System.out.println("Nombre del Apartamento: " + getName());
        System.out.println("Ciudad: " + getCity());
        System.out.println("Tipo de Instalación: " + getAccommodationType());
        System.out.println("Calificación: " + getRating() + " estrellas");
        System.out.println("Precio Base: $" + getBasePrice());
    }

    @Override
    public void updateReservations() {
        System.out.println("Updating reservations for Apartamento: " + getName());
    }
}