package Services;
import Models.*;
import Data.Data;
import Interface.IBooking;
import lib.AccommodationType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lib.AccommodationType.getAccomodationType;

public class BookingServices implements IBooking {

    public static List<Accommodation>hotels= Data.addHotels();
    public static List<Accommodation>apartments=Data.addApartment();
    public static List<Accommodation>lands=Data.addLands();
    public static List<Accommodation>sunnyDays=Data.addSunnyDay();
    public static Scanner scanner = new Scanner(System.in);
    private final List<Reservation<Accommodation>> reservations = new ArrayList<>();

    Hotel hotel ;
    Reservation reservation;

    public static void searchAccommodation(Scanner scanner) {
        scanner.nextLine();
        try {
            System.out.print("Ingrese ciudad: ");
            String city = scanner.nextLine();

            System.out.println("Seleccione una opcion (1-Hotel, 2-Apartamento, 3-Finca, 4-Día de Sol): ");

            Integer type= Integer.parseInt(scanner.nextLine());

            AccommodationType accommodationType = getAccomodationType(type);

            System.out.print("Fecha de inicio (yyyy-mm-dd): ");
            String startDateInput = scanner.nextLine();
            LocalDate startDate = LocalDate.parse(startDateInput, DateTimeFormatter.ISO_DATE);
            LocalDate endDate;

            if (accommodationType.equals(AccommodationType.SUNNYDAY)) {
                endDate = startDate;
            }
            else {
                System.out.print("Fecha de fin (yyyy-mm-dd): ");
                String endDateInput = scanner.nextLine();
                endDate = LocalDate.parse(endDateInput, DateTimeFormatter.ISO_DATE);
            }

            System.out.print("Número de Adultos: ");
            Integer adults = scanner.nextInt();

            System.out.print("Número de Menores: ");
            Integer children = scanner.nextInt();

            System.out.print("Números de reservas: ");
            Integer rooms = scanner.nextInt();

            List<Accommodation> accommodations = List.of();

            if (accommodationType == null) {
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                return;
            } else if (accommodationType.equals(AccommodationType.HOTEL)) {
                accommodations=hotels;
            } else if (accommodationType.equals(AccommodationType.APARTMENT)) {
                accommodations=apartments;
            } else if (accommodationType.equals(AccommodationType.LAND)) {
                accommodations=lands;
            } else if (accommodationType.equals(AccommodationType.SUNNYDAY)) {
                accommodations=sunnyDays;
            }
            List<Accommodation> matchingAccommodations = findAccommodations(
                    accommodations, city, startDate, endDate, adults, children, rooms
            );

            if (matchingAccommodations.isEmpty()) {
                System.out.println("No se encontraron coincidencias.");
            } else {
                System.out.println("Encontrados:");
                for (Accommodation accommodation : matchingAccommodations) {
                    accommodation.showInformation();
                }
            }

        }catch (Exception e) {
            System.out.println("Error: " +e);
        }
    }

    private static List<Accommodation> findAccommodations(
            List<Accommodation> accommodations,
            String city,
            LocalDate startDate,
            LocalDate endDate,
            Integer adults,
            Integer children,
            Integer rooms
    ) {
        List<Accommodation> results = new ArrayList<>();

        for (Accommodation accommodation : accommodations) {
            if (accommodation.getCity().equalsIgnoreCase(city) && accommodation.getCapacityAdults() > adults
                    && accommodation.getCapacityChildren() > children
            ) {
                System.out.printf("""
                            \n
                            Instalación: %s
                            Calificación: %.1f
                            Precio por noche: $%.2f
                            Precio total ajustado: $%.2f
                            """,
                        accommodation.getName(), accommodation.getRating(),accommodation.calculateBasePrice().getBasePrice(), accommodation.calculateTotalPrice(startDate, endDate, rooms));

                results.add(accommodation);
            }
        }
        return results;
    }

    public static void searchAndConfirmRoom() {

        try {

            System.out.print("Ingrese el nombre del hotel: ");
            String hotelName = scanner.nextLine();


            System.out.print("Ingrese la fecha de inicio (yyyy-mm-dd): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_DATE);


            System.out.print("Ingrese la fecha de fin (yyyy-mm-dd): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_DATE);


            System.out.print("Ingrese la cantidad de adultos: ");
            Integer adults = Integer.parseInt(scanner.nextLine());


            System.out.print("Ingrese la cantidad de niños: ");
            Integer children = Integer.parseInt(scanner.nextLine());


            System.out.print("Ingrese la cantidad de habitaciones requeridas: ");
            Integer roomsRequired = Integer.parseInt(scanner.nextLine());


            List<Room> availableRooms = confirmRooms(hotelName, startDate, endDate, adults, children, roomsRequired);


            if (availableRooms.isEmpty()) {
                System.out.println("No se encontraron habitaciones disponibles.");
            } else {
                System.out.println("Habitaciones disponibles confirmadas:");
                for (Room room : availableRooms) {
                    System.out.println(room);
                }
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }

    public static List<Room> confirmRooms(
            String hotelName,
            LocalDate startDate,
            LocalDate endDate,
            Integer adults,
            Integer children,
            Integer roomsRequired
    ) {
        Accommodation selectedHotel = hotels.stream()
                .filter(hotel -> hotel.getName().equalsIgnoreCase(hotelName))
                .findFirst()
                .orElse(null);

        if (selectedHotel == null) {
            System.out.println("Hotel no encontrado.");
            return List.of();
        }

        List<Room> availableRooms = selectedHotel.getRooms().stream()
                .filter(room->room.getAvailability() && room.getCapacityAdults() >= adults && room.getCapacityMinors() >= children && room.getAmountRooms() >= roomsRequired)
                .toList();

        if (availableRooms.isEmpty()) {
            System.out.println("No hay habitaciones disponibles para las fechas seleccionadas.");
            return List.of();
        }

        System.out.println("Habitaciones disponibles:");
        for (Room room : availableRooms) {
            System.out.println(room);
        }

        return availableRooms;
    }

    @Override
    public void confirmReservation() {


        try {
            // Recolectar datos del cliente
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

            Client client = new Client(firstName, lastName, email, phoneNumber, nationality, birthDate);

            System.out.print("Ingrese nombre del hotel: ");
            String hotelName = scanner.nextLine();

            System.out.print("Ingrese fecha de inicio (yyyy-mm-dd): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Ingrese fecha de fin (yyyy-mm-dd): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Ingrese la hora de llegada (HH:mm): ");
            LocalTime checkInTime = LocalTime.parse(scanner.nextLine());

            System.out.print("Ingrese el tipo de habitación: ");
            String roomType = scanner.nextLine();

            System.out.print("Ingrese la cantidad de habitaciones: ");
            Integer roomsToReserve = Integer.parseInt(scanner.nextLine());

            Accommodation selectedHotel = findAccommodationByName(hotelName);
            if (selectedHotel == null) {
                System.out.println("El alojamiento no fue encontrado.");
                return;
            }

            Room selectedRoom = findRoomByType(selectedHotel, roomType);
            if (selectedRoom == null || selectedRoom.getAmountRooms() < roomsToReserve) {
                System.out.println("No hay habitaciones disponibles del tipo especificado.");
                return;
            }

            Reservation<Accommodation> reservation = new Reservation<>(
                    client, selectedHotel, roomsToReserve, selectedRoom, startDate, endDate, checkInTime
            );
            reservations.add(reservation);

            selectedRoom.setAmountRooms(selectedRoom.getAmountRooms() - roomsToReserve);

            System.out.println("Se ha realizado la reserva con éxito.");
        } catch (Exception e) {
            System.out.println("Error durante el proceso de reserva: " + e.getMessage());
        }
    }

    private Accommodation findAccommodationByName(String name) {
        List<Accommodation> allAccommodations = new ArrayList<>();
        allAccommodations.addAll(BookingServices.hotels);
        allAccommodations.addAll(BookingServices.apartments);
        allAccommodations.addAll(BookingServices.lands);
        allAccommodations.addAll(BookingServices.sunnyDays);

        return allAccommodations.stream()
                .filter(accommodation -> accommodation.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    private Room findRoomByType(Accommodation accommodation, String roomType) {
        return accommodation.getRooms().stream()
                .filter(room -> room.getRoomType().equalsIgnoreCase(roomType))
                .findFirst()
                .orElse(null);
    }



    private void changeAccommodation(Reservation reserve) {
        hotel.eliminarReserva(reserve);
        System.out.println("Reserva eliminada.");

        System.out.println("Redirigiendo a la creación de una nueva reserva...");
        confirmReservation();
    }

    private Room findRoom(String tipo) {
        for (Room habitacion : hotel.getRooms()) {
            if (habitacion.getRoomType().equals(tipo)) {
                return habitacion;
            }
        }
        return null;
    }

    private void changeRoom(Reservation reservation) {
        Room currentRoom = reservation.getRoom();

        System.out.println("Habitación actual: " + currentRoom.getRoomType());

        System.out.println("Habitaciones disponibles:");
        for (Room habitacion : hotel.getRooms()) {
            if (habitacion.getAvailability()) {
                System.out.println("Tipo: " + habitacion.getRoomType());
            }
        }
        System.out.println("Seleccione la nueva habitación:");
        String nuevaHabitacion = scanner.nextLine();

        Room nuevaHabitacionObj = findRoom(nuevaHabitacion);
        if (nuevaHabitacionObj != null) {
            reservation.setRoom(nuevaHabitacionObj);
            System.out.println("Habitación actualizada a: " + nuevaHabitacion);
        } else {
            System.out.println("Habitación no válida.");
        }
    }

    @Override
    public void cancelReservation() {

    }

    @Override
    public void modifyRoom() {

            System.out.println("Ingrese su correo electrónico:");
            String correo = scanner.nextLine();
            System.out.println("Ingrese su fecha de nacimiento (YYYY-MM-DD):");
            LocalDate birthDate = LocalDate.parse(scanner.nextLine());

            Reservation reservation = hotel.getReservationByClient(correo, birthDate);

            if (reservation != null) {

                System.out.println("Reserva actual:");
                System.out.println("Cliente: " + reservation.getClient().getEmail());
                System.out.println("Habitación: " + reservation.getRoom().getRoomType());
                System.out.println("Fecha de entrada: " + reservation.getStartDate());
                System.out.println("Fecha de salida: " + reservation.getEndDate());

                System.out.println("¿Qué desea hacer?");
                System.out.println("1. Cambiar habitación");
                System.out.println("2. Cambiar alojamiento");
                Integer opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion == 1) {
                    changeRoom(reservation);
                } else if (opcion == 2) {
                    changeAccommodation(reservation);
                } else {
                    System.out.println("Opción no válida.");
                }
            } else {
                System.out.println("No se encontró ninguna reserva con esos datos.");

        }



    }

    @Override
    public void modifyAccommodation() {

    }
}

