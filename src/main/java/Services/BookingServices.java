package Services;

import Interface.IAccommodationService;
import Interface.IReservationService;
import Models.Accommodation;
import Models.Client;
import Models.InvalidReservationException;
import Models.ReservationDetails;
import Models.Room;
import Models.SearchCriteria;
import lib.AccommodationType;
import lib.AccommodationTypeUtil;
import lib.InputUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static lib.AccommodationUtils.createAndConfirmReservation;

public class BookingServices {
    private final IAccommodationService accommodationService;
    private final IReservationService reservationService;
    private final Scanner scanner;
    private AccommodationService accommodationServices;

    public BookingServices() {
        this.accommodationService = new AccommodationService();
        this.reservationService = new ReservationService();
        this.scanner = new Scanner(System.in);
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
            System.out.println("\nEncontrados:");
            for (Accommodation accommodation : accommodations) {
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
        }
    }

    private SearchCriteria getSearchCriteria() {
        System.out.print("Ingrese ciudad: ");
        String city = scanner.nextLine();
        System.out.println("Seleccione una opcion (1-Hotel, 2-Apartamento, 3-Finca, 4-Día de Sol): ");
        AccommodationType type = AccommodationTypeUtil.fromInt(Integer.parseInt(scanner.nextLine()));
        System.out.print("Fecha de inicio (yyyy-mm-dd): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_DATE);
        LocalDate endDate = getEndDate(type, startDate);
        System.out.print("Número de Adultos: ");
        int adults = Integer.parseInt(scanner.nextLine());
        System.out.print("Número de Menores: ");
        int children = Integer.parseInt(scanner.nextLine());
        System.out.print("Números de reservas: ");
        int rooms = Integer.parseInt(scanner.nextLine());

        return new SearchCriteria(city, type, startDate, endDate, adults, children, rooms);
    }

    private LocalDate getEndDate(AccommodationType type, LocalDate startDate) {
        if (type != AccommodationType.SUNNYDAY) {
            System.out.print("Fecha de fin (yyyy-mm-dd): ");
            return LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_DATE);
        }
        return startDate;
    }

    public void searchAndConfirmRoom() {
        String hotelName = InputUtil.getStringInput(scanner, "Ingrese el nombre del hotel: ");
        LocalDate startDate = InputUtil.getDateInput(scanner, "Ingrese la fecha de inicio (yyyy-mm-dd): ");
        LocalDate endDate = InputUtil.getDateInput(scanner, "Ingrese la fecha de fin (yyyy-mm-dd): ");
        int adults = InputUtil.getIntInput(scanner, "Ingrese la cantidad de adultos: ");
        int children = InputUtil.getIntInput(scanner, "Ingrese la cantidad de niños: ");
        int requiredRooms = InputUtil.getIntInput(scanner, "Ingrese la cantidad de habitaciones requeridas: ");

        List<Room> availableRooms = accommodationService.searchAvailableRooms(hotelName, startDate, endDate, adults, children, requiredRooms);
        displayAvailableRooms(availableRooms);
    }

    private void displayAvailableRooms(List<Room> availableRooms) {
        if (availableRooms.isEmpty()) {
            displayNoRoomsMessage();
        } else {
            displayRoomsList(availableRooms);
        }
    }

    private void displayNoRoomsMessage() {
        System.out.println("No se encontraron habitaciones disponibles para los criterios especificados.");
    }

    private void displayRoomsList(List<Room> rooms) {
        System.out.println("Habitaciones disponibles:");
        rooms.forEach(this::displayRoomDetails);
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

            Accommodation accommodation = validateAndGetAccommodation(details);
            Room room = validateAndGetRoom(accommodation, details);

            validateRoomAvailability(accommodation, room, details);

            createAndConfirmReservation(client, accommodation, room, details);
        } catch (InvalidReservationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            handleUnexpectedError(e);
        }
    }

    private Accommodation validateAndGetAccommodation(ReservationDetails details) throws InvalidReservationException {
        Accommodation accommodation = accommodationServices.findAccommodation(details.getAccommodationName());
        if (accommodation == null) {
            throw new InvalidReservationException("El alojamiento especificado no se encontró.");
        }
        return accommodation;
    }

    private Room validateAndGetRoom(Accommodation accommodation, ReservationDetails details) throws InvalidReservationException {
        Room room = accommodationServices.findRoom(accommodation, details.getRoomType());
        if (room == null) {
            throw new InvalidReservationException("El tipo de habitación especificado no se encontró.");
        }
        return room;
    }

    private void validateRoomAvailability(Accommodation accommodation, Room room, ReservationDetails details) throws InvalidReservationException {
        if (!accommodationServices.isRoomAvailable(accommodation, room, details)) {
            throw new InvalidReservationException("No hay disponibilidad para la habitación seleccionada.");
        }
    }

    private void handleUnexpectedError(Exception e) {
        System.out.println("Error inesperado durante el proceso de reserva: " + e.getMessage());
    }


    private Accommodation findAccommodation(ReservationDetails details) {
        Accommodation accommodation = accommodationServices.findAccommodation(details.getAccommodationName());
        if (accommodation == null) {
            System.out.println("El alojamiento especificado no se encontró.");
        }
        return accommodation;
    }

    private Room findRoom(Accommodation accommodation, ReservationDetails details) {
        Room room = accommodationServices.findRoom(accommodation, details.getRoomType());
        if (room == null) {
            System.out.println("El tipo de habitación especificado no se encontró.");
        }
        return room;
    }

    private boolean isRoomAvailable(Accommodation accommodation, Room room, ReservationDetails details) {
        if (!accommodationServices.isRoomAvailable(accommodation, room, details)) {
            System.out.println("No hay disponibilidad para la habitación seleccionada.");
            return false;
        }
        return true;
    }

    private void handleReservationError(Exception e) {
        System.out.println("Error durante el proceso de reserva: " + e.getMessage());
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
        int roomCount = InputUtil.getIntInput(scanner, "Ingrese la cantidad de habitaciones: ");

        return new ReservationDetails(accommodationName, startDate, endDate, checkInTime, roomType, roomCount);
    }

    public void changeReservation() {
        // reservationService.modifyReservation();
    }
}