package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.Main.*;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public class Booking implements IBooking {
    List<BookingData> bookingData;

    public Booking(){
        this.bookingData = new ArrayList<>();
    }

    public Booking(List<BookingData> bookingData) {
        this.bookingData = bookingData;
    }

    public static void menu () {
        int option = 1;
        Booking booking = new Booking();
        MenuOptionFactory factory = new MenuOptionFactory(booking);
            do {
                Menu.display();
                try {
                    option = InputCaptureUtil.captureInteger("Selecciona una opcion");
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Debes ingresar un numero");
                    option = 7;
                }
                input.nextLine();
                IMenuOption menuOption = factory.createOption(option);
                if (menuOption != null) {
                    menuOption.execute();
                } else {
                    System.out.println("Cerrando aplicacion...");
                }
            } while (option != 0);

    }

    @Override
    public void listBookings() {
        if (bookingData.isEmpty()) {
            System.out.println("No hay reservas disponibles.");
        } else {
            bookingData.forEach(System.out::println);
        }
    }

    @Override
    public String createBooking() {
        System.out.println("Creando una nueva reserva...");

        String lodgingName = InputCaptureUtil.captureString("Ingrese el nombre del alojamiento: ");
        Lodging selectedLodging = findLodgingByName(lodgingName);

        if (selectedLodging == null) {
            return "El alojamiento ingresado no existe.";
        }

        System.out.println("Habitaciones disponibles en " + lodgingName + ":");

        selectedLodging.getRooms().forEach(System.out::println);

        Integer numberOfRooms = InputCaptureUtil.captureInteger("Ingrese la cantidad de habitaciones que desea reservar: ");

        List<Room> availableRooms = fetchRoomsByAvaibility(selectedLodging, numberOfRooms);

        if (availableRooms.isEmpty()) {
            return "Error: No hay habitaciones disponibles para esa cantidad";
        }

        User user = captureUserData();
        String arrivalTime = InputCaptureUtil.captureString("Ingrese su hora aproximada de llegada (HH:mm): ");

        BookingData newBooking = new BookingData(user, selectedLodging, arrivalTime, numberOfRooms);
        bookingData.add(newBooking);

        for (Room room : availableRooms) {
            int remainingRooms = room.getAvaibility() - numberOfRooms;
            room.setAvaibility(remainingRooms);
            numberOfRooms -= room.getAvaibility();
            if (numberOfRooms <= 0) break;
        }

        return "Reserva creada exitosamente.";
    }

    @Override
    public List<Room> findAvailableRooms(Lodging selectedLodging, Integer roomsNeeded) {
        if (selectedLodging == null) {
            String lodgingName = InputCaptureUtil.captureString("No hay un alojamiento seleccionado. Ingrese el nombre del alojamiento: ");
            selectedLodging = lodgingList.stream()
                    .filter(lodging -> lodging.getName().equalsIgnoreCase(lodgingName))
                    .findFirst()
                    .orElse(null);

            if (selectedLodging == null) {
                System.out.println("Error: No se encontro un alojamiento con el nombre ingresado");
                return Collections.emptyList();
            }
        }

        return selectedLodging.getRooms().stream()
                .filter(room -> room.getAvaibility() > 0 && room.getAvaibility() >= roomsNeeded)
                .toList();
    }

    @Override
    public void findBookings() {
        Lodging lodgingData = captureLodgingData();
        Byte adults = InputCaptureUtil.captureByte("Ingrese la cantidad de adultos: ");
        Byte children = InputCaptureUtil.captureByte("Ingrese la cantidad de niños: ");
        Integer rooms = InputCaptureUtil.captureInteger("Ingresa la cantidad de habitaciones que necesitas: ");
        List<Lodging> availableLodgings = searchLodging(lodgingData, children, adults, rooms);

        printAvailableLodgings(availableLodgings);

    }

    @Override
    public String updateBooking() {
        String email = InputCaptureUtil.captureString("Ingrese su correo electronico: ");
        LocalDate birthDate = InputCaptureUtil.captureDate("Ingrese su fecha de nacimiento (yyyy-mm-dd): ");
        BookingData existingBooking = getExistingBookingByEmailAndBirthDate(email, birthDate);
        if (existingBooking == null) {
            return "Reserva no encontrada.";
        }
        System.out.println(existingBooking);
        if (shouldUpdateRoom()) {
            updateRoom(existingBooking);
        }
        if (shouldUpdateLodging()) {
            updateLodging(existingBooking);
        }
        return "Reserva actualizada exitosamente";
    }


    public Lodging findLodgingByName(String name) {
        return LodgingData.getInstance().getLodgingList().stream()
                .filter(lodging -> lodging.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<Room> fetchRoomsByAvaibility (Lodging selectedLodging, Integer numberOfRooms){
            return selectedLodging.getRooms().stream()
                    .filter(room -> room.getAvaibility() >= numberOfRooms)
                    .toList();
    }
    public User captureUserData(){
        String firstName = InputCaptureUtil.captureString("Ingrese su nombre: ");
        String lastName = InputCaptureUtil.captureString("Ingrese su apellido: ");
        String email = InputCaptureUtil.captureString("Ingrese su correo electronico: ");
        String nationality = InputCaptureUtil.captureString("Ingrese su nacionalidad: ");
        LocalDate birthDate = InputCaptureUtil.captureDate("Ingrese su fecha de nacimiento (yyyy-mm-dd): ");
        String phoneNumber = InputCaptureUtil.captureString("Ingrese su numero de telefono: ");

        return new User(firstName, lastName, email, nationality, phoneNumber, birthDate);
    }

    public Lodging captureLodgingData(){
        String city = InputCaptureUtil.captureString("Ingrese la ciudad deseada: ");
        String category = InputCaptureUtil.captureString("Ingrese el tipo del alojamiento deseado(Hotel, Apartamento, Finca, Dia de sol): ");
        LocalDate entryDay = InputCaptureUtil.captureDate("Ingrese la fecha de inicio de la estadia (yyyy-mm-dd): ");
        LocalDate endDay = InputCaptureUtil.captureDate("Ingrese la fecha del fin de la estadia (yyyy-mm-dd): ");

        return LodgingFactory.createLodging(city, category, entryDay, endDay);

    }
    public void printAvailableLodgings(List<Lodging> availableLodgings) {
        if (availableLodgings.isEmpty()) {
            System.out.println("No se encontraron alojamientos disponibles");
        } else {
            System.out.println("------- Alojamientos disponibles --------");
            for (int i = 0; i < availableLodgings.size(); i++) {
                System.out.printf("Opcion %d:%n%s%n", i + 1, availableLodgings.get(i).toString());
            }
        }
    }
    public List<Lodging> searchLodging(Lodging lodgingData, Byte children, Byte adults, Integer numberOfRooms) {
        return lodgingList.stream()
                .filter(lodging -> matchCategory(lodging, lodgingData)
                        && hasRoomAvailability(lodging, numberOfRooms)
                        && hasAdultCapacity(lodging, adults)
                        && hasChildCapacity(lodging, children)
                        && isWithinDateRange(lodging, lodgingData))
                .collect(Collectors.toList());
    }

    private boolean shouldUpdateRoom() {
        String response = InputCaptureUtil.captureString("desea cambiar la habitacion (s/n): ");
        return response.equalsIgnoreCase("s");
    }
    private void updateRoom(BookingData existingBooking) {
        Integer newRoomCount = InputCaptureUtil.captureInteger("Ingrese el numero de habitaciones necesarias: ");
        existingBooking.setNumberOfRoomsForBooking(newRoomCount);
        System.out.println("numero de habitaciones actualizado.");
    }

    private boolean shouldUpdateLodging() {
        String response = InputCaptureUtil.captureString("¿Desea cambiar el alojamiento? (s/n): ");
        return response.equalsIgnoreCase("s");
    }

    private void updateLodging(BookingData existingBooking) {
        String lodgingName = InputCaptureUtil.captureString("Ingrese el nombre del nuevo alojamiento: ");
        Lodging newLodging = findLodgingByName(lodgingName);

        if (newLodging != null) {
            existingBooking.setLodging(newLodging);
            System.out.println("Alojamiento actualizado.");
        } else {
            System.out.println("No se encontro el alojamiento.");
        }
    }
    private BookingData getExistingBookingByEmailAndBirthDate(String email, LocalDate birthDate) {
        return bookingData.stream()
                .filter(b -> b.getUser().getEmail().equals(email) && b.getUser().getBirthDate().equals(birthDate))
                .findFirst()
                .orElse(null);
    }


    public void printRooms(List<Room> rooms) {
        if (rooms.isEmpty()) {
            System.out.println("No se encontraron habitaciones disponibles");
        } else {
            System.out.println("------- Habitaciones disponibles --------");
            for (int i = 0; i < rooms.size(); i++) {
                System.out.printf("Opcion %d:%n%s%n", i + 1, rooms.get(i).toString());
            }
        }
    }

    public static Boolean matchCategory(Lodging lodging, Lodging lodgingData) {
        return lodging.getCategory().equals(lodgingData.getCategory());
    }
    public static Boolean hasRoomAvailability(Lodging lodging, Integer numberOfRooms) {
        return lodging.getRooms().stream().anyMatch(room -> room.getAvaibility() >= numberOfRooms);
    }

    public static Boolean hasAdultCapacity(Lodging lodging, Byte adults) {
        return lodging.getRooms().stream().anyMatch(room -> room.getAdultCapacity() >= adults);
    }

    public static Boolean hasChildCapacity(Lodging lodging, Byte children) {
        return lodging.getRooms().stream().anyMatch(room -> room.getChildCapacity() >= children);
    }

    public static Boolean isWithinDateRange(Lodging lodging, Lodging lodgingData) {
        return !lodging.getStartDateAvailable().isAfter(lodgingData.getStartDateAvailable()) &&
                !lodging.getEndDateAvailable().isBefore(lodgingData.getEndDateAvailable());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (BookingData data : bookingData) {
            sb.append("usuario: ").append(data.getUser())
                    .append("\nalojamiento: ").append(data.getLodging().getName())
                    .append("\ncategoria: ").append(data.getLodging().getCategory())
                    .append("\nfecha de llegada estimada: ").append(data.getEstimatedArrivalTime())
                    .append("\nhabitaciones reservadas: ").append(data.getNumberOfRoomsForBooking())
                    .append("\n---------------------------------\n");
        }
        if (bookingData.isEmpty()) {
            sb.append("No hay reservas registradas");
        }
        return sb.toString();
    }
}
