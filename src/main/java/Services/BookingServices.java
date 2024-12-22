package Services;

import Interface.IAccommodationService;
import Interface.IReservationService;
import Models.Accommodation;
import Models.Client;
import Models.Reservation;
import Models.InvalidReservationException;
import Models.ReservationDetails;
import Models.Room;
import Models.SearchCriteria;
import lib.AccommodationType;
import lib.AccommodationTypeUtil;
import lib.AccommodationUtils;
import lib.InputUtil;
import validators.ReservationValidator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import static lib.AccommodationUtils.createAndConfirmReservation;

public class BookingServices {
    private final IAccommodationService accommodationService;
    private final IReservationService reservationService;
    private final Scanner scanner;
    private final ReservationValidator reservationValidator;

    public BookingServices(Scanner scanner) {
        this.accommodationService = new AccommodationService();
        this.reservationService = new ReservationService();
        this.scanner = scanner;
        this.reservationValidator = new ReservationValidator((AccommodationService) accommodationService);
        AccommodationUtils.reservationService= (ReservationService) this.reservationService;
    }

    public void searchAccommodation() {
        SearchCriteria criteria = getSearchCriteria();
        List<Accommodation> matchingAccommodations = accommodationService.searchAccommodations(
          criteria.getCity(), criteria.getType(), criteria.getStartDate(), criteria.getEndDate(),
          criteria.getAdults(), criteria.getChildren(), criteria.getRooms()
        );

        displayMatchingAccommodations(matchingAccommodations, criteria);
    }

    private void displayMatchingAccommodations(List<Accommodation> accommodations, SearchCriteria criteria) {
        if (accommodations.isEmpty()) {
            System.out.println("No se encontraron coincidencias.");
        } else {
            accommodations.forEach(accommodation -> displayAccommodationDetails(accommodation, criteria));
        }
    }

    private void displayAccommodationDetails(Accommodation accommodation, SearchCriteria criteria) {
        accommodation.showInformation();
        System.out.printf("""
                Instalación: %s
                Calificación: %.1f
                Precio por noche: $%.2f
                Precio total ajustado: $%.2f
                \n""",
          accommodation.getName(), accommodation.getRating(),
          accommodation.calculateBasePrice().getBasePrice(),
          accommodation.calculateTotalPrice(criteria.getStartDate(), criteria.getEndDate(), criteria.getRooms()));
    }

    private SearchCriteria getSearchCriteria() {
        String city = InputUtil.getStringInput(scanner, "Ingrese ciudad: ");
        AccommodationType type = getAccommodationType();
        LocalDate startDate = InputUtil.getDateInput(scanner, "Fecha de inicio (yyyy-mm-dd): ");
        LocalDate endDate = getEndDate(type, startDate);
        Integer adults = InputUtil.getIntInput(scanner, "Número de Adultos: ");
        Integer children = InputUtil.getIntInput(scanner, "Número de Menores: ");
        Integer rooms = InputUtil.getIntInput(scanner, "Números de reservas: ");

        return new SearchCriteria(city, type, startDate, endDate, adults, children, rooms);
    }

    private AccommodationType getAccommodationType() {
        System.out.println("Seleccione una opcion (1-Hotel, 2-Apartamento, 3-Finca, 4-Día de Sol): ");
        return AccommodationTypeUtil.fromInt(Integer.parseInt(scanner.nextLine()));
    }

    private LocalDate getEndDate(AccommodationType type, LocalDate startDate) {
        if (type != AccommodationType.SUNNYDAY) {
            return InputUtil.getDateInput(scanner, "Fecha de fin (yyyy-mm-dd): ");
        }
        return startDate;
    }

    public void searchAndConfirmRoom() {
        String hotelName = InputUtil.getStringInput(scanner, "Ingrese el nombre del hotel: ");
        LocalDate startDate = InputUtil.getDateInput(scanner, "Ingrese la fecha de inicio (yyyy-mm-dd): ");
        LocalDate endDate = InputUtil.getDateInput(scanner, "Ingrese la fecha de fin (yyyy-mm-dd): ");
        Integer adults = InputUtil.getIntInput(scanner, "Ingrese la cantidad de adultos: ");
        Integer children = InputUtil.getIntInput(scanner, "Ingrese la cantidad de niños: ");
        Integer requiredRooms = InputUtil.getIntInput(scanner, "Ingrese la cantidad de habitaciones requeridas: ");

        List<Room> availableRooms = accommodationService.searchAvailableRooms(hotelName, startDate, endDate, adults, children, requiredRooms);
        displayAvailableRooms(availableRooms);
    }

    private void displayAvailableRooms(List<Room> availableRooms) {
        if (availableRooms.isEmpty()) {
            System.out.println("No se encontraron habitaciones disponibles para los criterios especificados.");
        } else {
            availableRooms.forEach(this::displayRoomDetails);
        }
    }

    private void displayRoomDetails(Room room) {
        System.out.println("\nTipo de habitación: " + room.getRoomType());
        System.out.println("Características: " + room.getDescription());
        System.out.println("Precio por noche: $" + room.getBasePrice());
        System.out.println("Capacidad: " + room.getCapacityAdults() + " adultos, " + room.getCapacityMinors() + " niños");
        System.out.println("Habitaciones disponibles: " + room.getAmountRooms());
    }

    public void confirmReservation() {
        try {
            Client client = getClientInfo();
            ReservationDetails details = getReservationDetails();

            Accommodation accommodation = reservationValidator.validateAndGetAccommodation(details);
            Room room = reservationValidator.validateAndGetRoom(accommodation, details);

            reservationValidator.validateRoomAvailability(accommodation, room, details);

            createAndConfirmReservation(client, accommodation, room, details);
        } catch (InvalidReservationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado durante el proceso de reserva: " + e.getMessage());
        }
    }

    private Client getClientInfo() {
        String firstName = InputUtil.getStringInput(scanner, "Ingrese nombre: ");
        String lastName = InputUtil.getStringInput(scanner, "Ingrese apellido: ");
        String email = InputUtil.getStringInput(scanner, "Ingrese email: ");
        String phoneNumber = InputUtil.getStringInput(scanner, "Ingrese número de teléfono: ");
        String nationality = InputUtil.getStringInput(scanner, "Ingrese nacionalidad: ");
        LocalDate birthDate = InputUtil.getDateInput(scanner, "Ingrese fecha de nacimiento (yyyy-mm-dd): ");

        return new Client(firstName, lastName, email, phoneNumber, nationality, birthDate);
    }

    private ReservationDetails getReservationDetails() {
        String accommodationName = InputUtil.getStringInput(scanner, "Ingrese nombre del hotel: ");
        LocalDate startDate = InputUtil.getDateInput(scanner, "Ingrese fecha de inicio (yyyy-mm-dd): ");
        LocalDate endDate = InputUtil.getDateInput(scanner, "Ingrese fecha de fin (yyyy-mm-dd): ");
        LocalTime checkInTime = InputUtil.getTimeInput(scanner, "Ingrese la hora de llegada (HH:mm): ");
        String roomType = InputUtil.getStringInput(scanner, "Ingrese el tipo de habitación: ");
        Integer roomCount = InputUtil.getIntInput(scanner, "Ingrese la cantidad de habitaciones: ");

        return new ReservationDetails(accommodationName, startDate, endDate, checkInTime, roomType, roomCount);
    }

    public void handleExitOption() {
        System.out.println("Saliendo del sistema. ¡Gracias por usar el sistema de reservas!");
    }

    public void changeReservation() {
        String email = InputUtil.getStringInput(scanner, "Ingrese su email: ");
        String birthDate = InputUtil.getStringInput(scanner, "Ingrese su fecha de nacimiento: ");
        Reservation reservation = ReservationService.getReservation(email, birthDate);
        if (reservation == null) {
            System.out.println("No se encontró ninguna reserva con los datos proporcionados.");
            return;
        }
        reservationService.modifyReservation(reservation, scanner);
    }
}