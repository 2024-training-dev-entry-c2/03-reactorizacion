package Services;

import Interface.IReservationService;
import Models.Accommodation;
import Models.Client;
import Models.Reservation;
import Models.Room;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static lib.ReservationUtil.authenticateAndValidateReservation;
import static lib.ReservationUtil.changeRoom;
import static lib.ReservationUtil.displayReservationDetails;
import static lib.ReservationUtil.getModificationOption;
import static lib.ReservationUtil.resetRoomAvailability;
import static lib.ReservationUtil.updateRoomAvailability;

public class ReservationService implements IReservationService {
    private final List<Reservation<Accommodation>> reservations = new ArrayList<>();

    public ReservationService() {
    }

    @Override
    public Reservation createReservation(Client client, Accommodation accommodation, int roomCount, Room room, LocalDate startDate, LocalDate endDate, LocalTime checkInTime) {
        Reservation<Accommodation> reservation = new Reservation<>(client, accommodation, roomCount, room, startDate, endDate);
        reservations.add(reservation);
        room.setAmountRooms(room.getAmountRooms() - roomCount);
        return reservation;
    }

    @Override
    public void modifyReservation(Reservation reservation, Room newRoom, Scanner scanner) {
        resetRoomAvailability(reservation);

        try {
            if (!authenticateAndValidateReservation(reservation, scanner)) {
                return;
            }

            displayReservationDetails(reservation);

            Integer option = getModificationOption(scanner);
            handleModificationOption(option, reservation, scanner);

            updateRoomAvailability(reservation, newRoom);
        } catch (Exception e) {
            System.out.println("Error durante la modificación de la reserva: " + e.getMessage());
        }
    }

    private void handleModificationOption(Integer option, Reservation reservation, Scanner scanner) {
        Map<Integer, Runnable> optionActions = new HashMap<>();

        optionActions.put(1, () -> changeRoom(reservation, scanner));
        optionActions.put(2, () -> changeAccommodation(reservation));

        Runnable action = optionActions.get(option);
        if (action != null) {
            action.run();
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private void changeAccommodation(Reservation reservation) {
        reservations.remove(reservation);
        Room room = reservation.getRoom();
        room.setAmountRooms(room.getAmountRooms() + reservation.getNumberOfRooms());

        System.out.println("Reserva eliminada. Por favor, realice una nueva reserva.");
    }
}