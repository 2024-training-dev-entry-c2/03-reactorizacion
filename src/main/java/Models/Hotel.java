package Models;

import java.util.List;

public class Hotel extends Accommodation {

    public Hotel(String city, String accommodationType, List<Room> rooms , List<Reservation> reservations, Float rating, String name) {
        super(city, accommodationType, rooms , rating, name, reservations);
    }

    @Override
    public void showInformation() {
        System.out.println("Nombre del Hotel: " + getName());
        System.out.println("Ciudad: " + getCity());
        System.out.println("Tipo de Instalación: " + getAccommodationType());
        System.out.println("Calificación: " + getRating() + " estrellas");
    }

}