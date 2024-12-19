package Services;

import Interface.IAccommodationService;
import Models.*;
import Interface.IReservationService;
import lib.AccommodationType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class BookingServices implements IReservationService {
    private final IAccommodationService accommodationService;
    private final IReservationService reservationService;
    private final Scanner scanner;

    public BookingServices() {
        this.accommodationService = new AccommodationService();
        this.reservationService = new ReservationService();
        this.scanner = new Scanner(System.in);
    }

    public void searchAccommodation() {
        SearchCriteria criteria = getSearchCriteria();
        List<Accommodation> matchingAccommodations = accommodationService.searchAccommodations(
                criteria.city, criteria.type, criteria.startDate, criteria.endDate,
                criteria.adults, criteria.children, criteria.rooms
        );

        if (matchingAccommodations.isEmpty()) {
            System.out.println("No se encontraron coincidencias.");
        } else {
            System.out.println("\nEncontrados:");
            for (Accommodation accommodation : matchingAccommodations) {
                accommodation.showInformation();
                System.out.printf("""
                        Instalación: %s
                        Calificación: %.1f
                        Precio por noche: $%.2f
                        Precio total ajustado: $%.2f
                        \n""",
                        accommodation.getName(), accommodation.getRating(),
                        accommodation.calculateBasePrice().getBasePrice(),
                        accommodation.calculateTotalPrice(criteria.startDate, criteria.endDate, criteria.rooms));
            }
        }
    }
    private SearchCriteria getSearchCriteria() {
        System.out.print("Ingrese ciudad: ");
        String city = scanner.nextLine();
        System.out.println("Seleccione una opcion (1-Hotel, 2-Apartamento, 3-Finca, 4-Día de Sol): ");
        AccommodationType type = AccommodationType.getAccomodationType(Integer.parseInt(scanner.nextLine()));
        System.out.print("Fecha de inicio (yyyy-mm-dd): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_DATE);
        if (type != AccommodationType.SUNNYDAY){
            System.out.print("Fecha de fin (yyyy-mm-dd): ");
        }
        LocalDate endDate = type == AccommodationType.SUNNYDAY ? startDate :
                LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_DATE);
        System.out.print("Número de Adultos: ");
        int adults = Integer.parseInt(scanner.nextLine());
        System.out.print("Número de Menores: ");
        int children = Integer.parseInt(scanner.nextLine());
        System.out.print("Números de reservas: ");
        int rooms = Integer.parseInt(scanner.nextLine());

        return new SearchCriteria(city, type, startDate, endDate, adults, children, rooms);
    }

    private Client getClientInfo() {
        System.out.print("Ingrese nombre: ");
        String firstName = scanner.nextLine();
        System.out.print("Ingrese apellido: ");
        String lastName = scanner.nextLine();
        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese número de teléfono: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Ingrese nacionalidad: ");
        String nationality = scanner.nextLine();
        System.out.print("Ingrese fecha de nacimiento (yyyy-mm-dd): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        return new Client(firstName, lastName, email, phoneNumber, nationality, birthDate);
    }

    private ReservationDetails getReservationDetails() {
        System.out.print("Ingrese nombre del hotel: ");
        String accommodationName = scanner.nextLine();
        System.out.print("Ingrese fecha de inicio (yyyy-mm-dd): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Ingrese fecha de fin (yyyy-mm-dd): ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Ingrese la hora de llegada (HH:mm): ");
        LocalTime checkInTime = LocalTime.parse(scanner.nextLine());
        System.out.print("Ingrese el tipo de habitación: ");
        String roomType = scanner.nextLine();
        System.out.print("Ingrese la cantidad de habitaciones: ");
        int roomCount = Integer.parseInt(scanner.nextLine());

        return new ReservationDetails(accommodationName, startDate, endDate, checkInTime, roomType, roomCount);
    }

    @Override
    public void confirmReservation() {
        try {

            System.out.print("Ingrese nombre: ");
            String firstName = scanner.nextLine();

            System.out.print("Ingrese apellido: ");
            String lastName = scanner.nextLine();

            System.out.print("Ingrese email: ");
            String email = scanner.nextLine();

            System.out.print("Ingrese nacionalidad: ");
            String nationality = scanner.nextLine();

            System.out.print("Ingrese número de teléfono: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Ingrese hora aproximada de llegada (HH:mm): ");
            LocalTime arrivalTime = LocalTime.parse(scanner.nextLine());

            System.out.print("Ingrese nombre del hotel: ");
            String hotelName = scanner.nextLine();

            System.out.print("Ingrese tipo de habitación: ");
            String roomType = scanner.nextLine();

            System.out.print("Ingrese fecha de inicio (yyyy-MM-dd): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Ingrese fecha de fin (yyyy-MM-dd): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Ingrese número de habitaciones: ");
            int roomCount = Integer.parseInt(scanner.nextLine());

            Client client = new Client(firstName, lastName, email, phoneNumber, nationality, LocalDate.now());

            Accommodation accommodation = accommodationService.findAccommodationByName(hotelName);
            if (accommodation == null) {
                System.out.println("El alojamiento especificado no fue encontrado.");
                return;
            }

            Room room = accommodationService.findRoomByType(accommodation, roomType);
            if (room == null) {
                System.out.println("El tipo de habitación especificado no está disponible en este alojamiento.");
                return;
            }

            if (!accommodationService.isRoomAvailable(room,startDate,endDate, accommodation.getCapacityAdults(), accommodation.getCapacityChildren(), roomCount)) {
                System.out.println("No hay suficientes habitaciones disponibles para las fechas especificadas.");
                return;
            }

            Reservation<Accommodation> reservation = reservationService.createReservation(client, accommodation, roomCount, room, startDate, endDate, arrivalTime);

            if (reservation != null) {
                System.out.println("Se ha realizado la reserva con éxito.");
            } else {
                System.out.println("No se pudo completar la reserva. Por favor, intente nuevamente.");
            }

        } catch (Exception e) {
            System.out.println("Error durante el proceso de reserva: " + e.getMessage());
        }
    }

    @Override
    public Reservation createReservation(Client client, Accommodation accommodation, int roomCount, Room room, LocalDate startDate, LocalDate endDate, LocalTime checkInTime) {
        try {
            Client customer = getClientInfo();
            ReservationDetails details = getReservationDetails();

            Accommodation accommodations = accommodationService.findAccommodationByName(details.accommodationName);
            if (accommodation == null) {
                System.out.println("El alojamiento no fue encontrado.");
                return null;
            }

            Room rooms = accommodationService.findRoomByType(accommodation, details.roomType);
            if (room == null || room.getAmountRooms() < details.roomCount) {
                System.out.println("No hay habitaciones disponibles del tipo especificado.");
                return null;
            }

            Reservation<Accommodation> reservation = reservationService.createReservation(
                    client, accommodation, details.roomCount, room,
                    details.startDate, details.endDate, details.checkInTime
            );

            System.out.println("Se ha realizado la reserva con éxito.");
            return reservation;
        } catch (Exception e) {
            System.out.println("Error durante el proceso de reserva: " + e.getMessage());
        }

        return null;
    }

    @Override
    public void cancelReservation(Reservation reservation) {

    }

    @Override
    public void modifyReservation(Reservation reservation, Room newRoom) {

    }

    private static class SearchCriteria {
        String city;
        AccommodationType type;
        LocalDate startDate;
        LocalDate endDate;
        int adults;
        int children;
        int rooms;

        SearchCriteria(String city, AccommodationType type, LocalDate startDate, LocalDate endDate, int adults, int children, int rooms) {
            this.city = city;
            this.type = type;
            this.startDate = startDate;
            this.endDate = endDate;
            this.adults = adults;
            this.children = children;
            this.rooms = rooms;
        }
    }

    private static class ReservationDetails {
        String accommodationName;
        LocalDate startDate;
        LocalDate endDate;
        LocalTime checkInTime;
        String roomType;
        int roomCount;

        ReservationDetails(String accommodationName, LocalDate startDate, LocalDate endDate, LocalTime checkInTime, String roomType, int roomCount) {
            this.accommodationName = accommodationName;
            this.startDate = startDate;
            this.endDate = endDate;
            this.checkInTime = checkInTime;
            this.roomType = roomType;
            this.roomCount = roomCount;
        }
    }
    public void searchAndConfirmRoom(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Ingrese el nombre del hotel: ");
        String hotelName = scanner.nextLine();

        System.out.print("Ingrese la fecha de inicio (yyyy-mm-dd): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_DATE);

        System.out.print("Ingrese la fecha de fin (yyyy-mm-dd): ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_DATE);

        System.out.print("Ingrese la cantidad de adultos: ");
        int adults = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese la cantidad de niños: ");
        int children = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese la cantidad de habitaciones requeridas: ");
        int requiredRooms = Integer.parseInt(scanner.nextLine());

        List<Room> availableRooms = accommodationService.searchAvailableRooms(hotelName, startDate, endDate, adults, children, requiredRooms);

        if (availableRooms.isEmpty()) {
            System.out.println("No se encontraron habitaciones disponibles para los criterios especificados.");
        } else {
            System.out.println("Habitaciones disponibles:");
            for (Room room : availableRooms) {
                System.out.println("\nTipo de habitación: " + room.getRoomType());
                System.out.println("Características: " + room.getDescription());
                System.out.println("Precio por noche: $" + room.getBasePrice());
                System.out.println("Capacidad: " + room.getCapacityAdults() + " adultos, " + room.getCapacityMinors() + " niños");
                System.out.println("Habitaciones disponibles: " + room.getAmountRooms());
            }
        }
    }
}


