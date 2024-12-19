package Models;

import java.time.LocalDate;
import java.util.List;

import static lib.DateUtils.*;
import static lib.RoomUtils.getSimplestRoom;

public abstract class Accommodation {

    private String city;
    private String accommodationType;
    protected List<Room> rooms;
    protected List<Reservation> reservations;
    private float rating;
    private String name;

    public Accommodation(String city, String accommodationType, List<Room> rooms, float rating, String name, List<Reservation> reservations) {
        this.city = city;
        this.accommodationType = accommodationType;
        this.rooms = rooms;
        this.rating = rating;
        this.reservations = reservations;
        this.name = name;
    }

    public Reservation getReservationByClient(String email, LocalDate birthDate) {
        for (Reservation reservation : reservations) {
            if (reservation.getClient().getEmail().equals(email) &&
                    reservation.getClient().getBirthDate().equals(birthDate)) {
                return reservation;
            }
        }
        return null;
    }

    public int getCapacityAdults() {
        return getSimplestRoom(rooms).getCapacityAdults();
    }

    public int getCapacityChildren() {
        return getSimplestRoom(rooms).getCapacityMinors();
    }

    public Room calculateBasePrice() {
        return  getSimplestRoom(rooms);
    }

    public double calculateTotalPrice(LocalDate startDay, LocalDate endDay, int numberOfRooms) {

        double simpleRoomPrice = calculateBasePrice().getBasePrice();

        double totalPrice = simpleRoomPrice * numberOfRooms *(endDay.getDayOfMonth() - startDay.getDayOfMonth());

        if (isLastFiveDaysOfMonth(endDay)) {
            double discountOrIncrease = totalPrice * 0.15; // 15% increase
            totalPrice += discountOrIncrease;
        } else if (isWithinRange(startDay, endDay, 10, 15)) {
            double discountOrIncrease = totalPrice * 0.10; // 10% increase
            totalPrice += discountOrIncrease;
        } else if (isWithinRange(startDay, endDay, 5, 10)) {
            double discountOrIncrease = totalPrice * 0.08; // 8% discount
            totalPrice -= discountOrIncrease;
        }

        return totalPrice;
    }

    public Reservation getReserveByClient(String email, LocalDate birthDate) {
        for (Reservation reserve : reservations) {
            if (reserve.getClient().getEmail().equals(email) &&
                    reserve.getClient().getBirthDate().equals(birthDate)) {
                return reserve;
            }
        }
        return null;
    }

    public void eliminarReserva(Reservation reserva) {
        reservations.remove(reserva);
    }


    public String getCity() {
        return city;
    }

    public String getAccommodationType() {
        return accommodationType;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Float getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public abstract void showInformation();

    public abstract void updateReservations();
}