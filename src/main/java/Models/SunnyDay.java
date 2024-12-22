package Models;

import java.util.List;

public class SunnyDay extends Accommodation {

    private Boolean includesLunch;
    private Boolean includesSnack;

    public SunnyDay(String city, String accommodationType, List<Room> rooms , List<Reservation> reservations, Float rating, String name, Boolean includesLunch, Boolean includesSnack) {
        super(city, accommodationType, rooms, rating, name, reservations);
        this.includesLunch = includesLunch;
        this.includesSnack = includesSnack;
    }

    @Override
    public void showInformation() {
      String info = "Nombre del Alojamiento: " + getName() + "\n" +
        "Ciudad: " + getCity() + "\n" +
        "Tipo de Alojamiento: " + getAccommodationType() + "\n" +
        "Calificación: " + getRating() + " estrellas\n" +
        "Incluye Almuerzo: " + formatBoolean(includesLunch) + "\n" +
        "Incluye Refrigerio: " + formatBoolean(includesSnack) + "\n";

        System.out.println(info);
    }

    private String formatBoolean(Boolean value) {
        return value ? "Sí" : "No";
    }
}