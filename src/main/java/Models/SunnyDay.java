package Models;

import java.time.LocalDate;
import java.util.List;

import static lib.DateUtils.isLastFiveDaysOfMonth;
import static lib.DateUtils.isWithinDayRange;
import static lib.RoomUtils.getSimplestRoom;

public class SunnyDay extends Accommodation {

    private boolean includesLunch;
    private boolean includesSnack;

    public SunnyDay(String city, String accommodationType, List<Room> rooms, float rating, String name, boolean includesLunch, boolean includesSnack) {
        super(city, accommodationType, rooms, rating, name);
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

    @Override
    public void updateReservations() {
        System.out.println("Updating reservations for SunnyDay: " + getName());
    }

    public double calculateTotalPrice(LocalDate day) {
        double totalPrice = calculateBasePrice().getBasePrice();

        if (isLastFiveDaysOfMonth(day)) {
            double discountOrIncrease = totalPrice * 0.15; // 15% increase
            totalPrice += discountOrIncrease;
        } else if (isWithinDayRange(day, 10, 15)) {
            double discountOrIncrease = totalPrice * 0.10; // 10% increase
            totalPrice += discountOrIncrease;
        } else if (isWithinDayRange(day, 5, 10)) {
            double discountOrIncrease = totalPrice * 0.08; // 8% discount
            totalPrice -= discountOrIncrease;
        }
        return totalPrice;
    }
}