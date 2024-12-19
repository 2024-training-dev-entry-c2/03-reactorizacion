package Services;

import Interface.IReservationService;
import Models.Accommodation;
import Models.Client;
import Models.Reservation;
import Models.Room;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationService implements IReservationService {
    private final List<Reservation<Accommodation>> reservations = new ArrayList<>();

    @Override
    public Reservation createReservation(Client client, Accommodation accommodation, int roomCount, Room room, LocalDate startDate, LocalDate endDate, LocalTime checkInTime) {
        Reservation<Accommodation> reservation = new Reservation<>(client, accommodation, roomCount, room, startDate, endDate, checkInTime);
        reservations.add(reservation);
        room.setAmountRooms(room.getAmountRooms() - roomCount);
        return reservation;
    }

    @Override
    public void cancelReservation(Reservation reservation) {
        reservations.remove(reservation);
        Room room = reservation.getRoom();
        room.setAmountRooms(room.getAmountRooms() + reservation.getNumberOfRooms());
    }

    @Override
    public void confirmReservation() {

    }

    @Override
    public void modifyReservation(Reservation reservation, Room newRoom) {
        Room oldRoom = reservation.getRoom();
        oldRoom.setAmountRooms(oldRoom.getAmountRooms() + reservation.getNumberOfRooms());

        reservation.setRoom(newRoom);
        newRoom.setAmountRooms(newRoom.getAmountRooms() - reservation.getNumberOfRooms());
    }
}

