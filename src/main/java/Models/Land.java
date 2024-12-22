package Models;

import java.util.List;

public class Land extends Accommodation {

    public Land(String city, String accommodationType, List<Room> rooms,List<Reservation>reservations, Float rating, String name) {
        super(city, accommodationType, rooms, rating, name, reservations);
    }

    @Override
    public void showInformation() {
        System.out.println("Nombre de la Finca: " + getName());
        System.out.println("Ciudad: " + getCity());
        System.out.println("Tipo de Instalación: " + getAccommodationType());
        System.out.println("Calificación: " + getRating() + " estrellas");
    }
}