package Models;

import java.time.LocalDate;
import java.util.List;

import static lib.DateUtils.isLastFiveDaysOfMonth;
import static lib.DateUtils.isWithinDayRange;
import static lib.RoomUtils.getSimplestRoom;

public class SunnyDay extends Accommodation {

    private boolean includesLunch;
    private boolean includesSnack;

    public SunnyDay(String city, String accommodationType, List<Room> rooms , List<Reservation> reservations, Float rating, String name, boolean includesLunch, boolean includesSnack) {
        super(city, accommodationType, rooms, rating, name, reservations);
        this.includesLunch = includesLunch;
        this.includesSnack = includesSnack;
    }

    @Override
    public void showInformation() {
        System.out.println("Nombre del Alojamiento: " + getName());
        System.out.println("Ciudad: " + getCity());
        System.out.println("Tipo de Alojamiento: " + getAccommodationType());
        System.out.println("Calificación: " + getRating() + " estrellas");
        System.out.println("Incluye Almuerzo: " + (includesLunch ? "Sí" : "No"));
        System.out.println("Incluye Refrigerio: " + (includesSnack ? "Sí" : "No"));
    }

    public Double calculateTotalPrice(LocalDate day) {
        Double totalPrice = calculateBasePrice().getBasePrice();

        if (isLastFiveDaysOfMonth(day)) {
            Double discountOrIncrease = totalPrice * 0.15; // 15% increase
            totalPrice += discountOrIncrease;
        } else if (isWithinDayRange(day, 10, 15)) {
            Double discountOrIncrease = totalPrice * 0.10; // 10% increase
            totalPrice += discountOrIncrease;
        } else if (isWithinDayRange(day, 5, 10)) {
            Double discountOrIncrease = totalPrice * 0.08; // 8% discount
            totalPrice -= discountOrIncrease;
        }
        return totalPrice;
    }
}