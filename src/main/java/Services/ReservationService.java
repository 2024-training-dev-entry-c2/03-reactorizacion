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
import java.util.Scanner;

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
        Room oldRoom = reservation.getRoom();
        oldRoom.setAmountRooms(oldRoom.getAmountRooms() + reservation.getNumberOfRooms());

        try {
            if (!authenticateClient(reservation, scanner)) {
                System.out.println("Autenticación fallida. No se puede modificar la reserva.");
                return;
            }
            displayReservationDetails(reservation);

            int option = getModificationOption(scanner);
            handleModificationOption(option, reservation, scanner);
        } catch (Exception e) {
            System.out.println("Error durante la modificación de la reserva: " + e.getMessage());
        }

        reservation.setRoom(newRoom);
        newRoom.setAmountRooms(newRoom.getAmountRooms() - reservation.getNumberOfRooms());
    }

    private int getModificationOption(Scanner scanner) {
        System.out.println("¿Desea cambiar de habitación (1) o de alojamiento (2)?");
        return Integer.parseInt(scanner.nextLine());
    }

    private void handleModificationOption(int option, Reservation reservation, Scanner scanner) {
        if (option == 1) {
            changeRoom(reservation, scanner);
        } else if (option == 2) {
            changeAccommodation(reservation);
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private Boolean authenticateClient(Reservation reservation, Scanner scanner) {
        String email = reservation.getClient().getEmail();
        LocalDate birthDate = reservation.getClient().getBirthDate();

        System.out.print("Ingrese su correo: ");
        String inputEmail = scanner.nextLine();

        System.out.print("Ingrese su fecha de nacimiento (yyyy-MM-dd): ");
        LocalDate inputBirthDate = LocalDate.parse(scanner.nextLine());

        return inputEmail.equals(email) && inputBirthDate.equals(birthDate);
    }

    private void displayReservationDetails(Reservation reservation) {
        System.out.println("Reserva actual:");
        System.out.println("Alojamiento: " + reservation.getAccommodation());
        System.out.println("Tipo de habitación: " + reservation.getRoom().getRoomType());
        System.out.println("Fechas: " + reservation.getStartDate() + " a " + reservation.getEndDate());
    }

    private void changeAccommodation(Reservation reservation) {
        reservations.remove(reservation);
        Room room = reservation.getRoom();
        room.setAmountRooms(room.getAmountRooms() + reservation.getNumberOfRooms());

        System.out.println("Reserva eliminada. Por favor, realice una nueva reserva.");
    }

    private void changeRoom(Reservation reservation, Scanner scanner) {
        Room oldRoom = reservation.getRoom();
        displayCurrentRoom(oldRoom);

        Accommodation accommodation = (Accommodation) reservation.getAccommodation();
        displayAvailableRooms(accommodation, reservation);

        Room newRoomSelection = getNewRoomSelection(accommodation, scanner);
        if (newRoomSelection == null) {
            System.out.println("La habitación seleccionada no está disponible.");
            return;
        }

        updateRoomAvailability(oldRoom, newRoomSelection, reservation);
        System.out.println("La reserva ha sido modificada con éxito.");
    }

    private void displayCurrentRoom(Room oldRoom) {
        System.out.println("Habitación actual: " + oldRoom.getRoomType());
    }

    private void displayAvailableRooms(Accommodation accommodation, Reservation reservation) {
        System.out.println("Habitaciones disponibles en el alojamiento " + accommodation.getName() + ":");
        for (Room availableRoom : accommodation.getRooms()) {
            if (availableRoom.getCapacityAdults() >= reservation.getNumberOfRooms()) {
                System.out.println(availableRoom.getRoomType());
            }
        }
    }

    private Room getNewRoomSelection(Accommodation accommodation, Scanner scanner) {
        System.out.print("Ingrese el tipo de habitación a la que desea cambiar: ");
        String newRoomType = scanner.nextLine();
        return accommodation.getRooms().stream()
                .filter(r -> r.getRoomType().equals(newRoomType))
                .findFirst()
                .orElse(null);
    }

    private void updateRoomAvailability(Room oldRoom, Room newRoomSelection, Reservation reservation) {
        oldRoom.setAmountRooms(oldRoom.getAmountRooms() + reservation.getNumberOfRooms());
        reservation.setRoom(newRoomSelection);
        newRoomSelection.setAmountRooms(newRoomSelection.getAmountRooms() - reservation.getNumberOfRooms());
    }
}