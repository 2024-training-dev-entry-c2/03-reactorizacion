package Services;
import Models.*;
import Data.Data;
import Interface.IBooking;
import Models.Accommodation;
import lib.AccommodationType;

import java.time.LocalDate;
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

    public static void searchAccommodation(Scanner scanner) {
        scanner.nextLine();
        try {
            System.out.print("Ingrese ciudad: ");
            String city = scanner.nextLine();

            System.out.println("Seleccione una opcion (1-Hotel, 2-Apartamento, 3-Finca, 4-Día de Sol): ");

            int type= Integer.parseInt(scanner.nextLine());

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
            int adults = scanner.nextInt();

            System.out.print("Número de Menores: ");
            int children = scanner.nextInt();

            System.out.print("Números de reservas: ");
            int rooms = scanner.nextInt();

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
            int adults,
            int children,
            int rooms
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
        Scanner scanner = new Scanner(System.in);

        try {

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
            int roomsRequired = Integer.parseInt(scanner.nextLine());


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
            int adults,
            int children,
            int roomsRequired
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

    }

    @Override
    public void showInformation() {

    }

    @Override
    public void cancelReservation() {

    }

    @Override
    public void modifyRoom() {

    }

    @Override
    public void modifyAccommodation() {

    }
}

