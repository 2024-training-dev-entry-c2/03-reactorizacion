package Models;

import java.util.List;

public class SunnyDay extends Accommodation {

    private boolean includesLunch;
    private boolean includesSnack;

    public SunnyDay(String city, String accommodationType, List<Room> rooms, float rating, String name, float basePrice, boolean includesLunch, boolean includesSnack) {
        super(city, accommodationType, rooms, rating, name, basePrice);
        this.includesLunch = includesLunch;
        this.includesSnack = includesSnack;
    }

    @Override
    public void showInformation() {
        System.out.println("Nombre del Alojamiento: " + getName());
        System.out.println("Ciudad: " + getCity());
        System.out.println("Tipo de Alojamiento: " + getAccommodationType());
        System.out.println("Calificación: " + getRating() + " estrellas");
        System.out.println("Precio Base: $" + getBasePrice());
        System.out.println("Incluye Almuerzo: " + (includesLunch ? "Sí" : "No"));
        System.out.println("Incluye Refrigerio: " + (includesSnack ? "Sí" : "No"));
    }

    @Override
    public void updateReservations() {
        System.out.println("Updating reservations for SunnyDay: " + getName());
    }
}