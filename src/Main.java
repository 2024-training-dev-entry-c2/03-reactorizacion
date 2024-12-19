import java.util.List;
import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    private static final ReservationImplementation reservationSystem = new ReservationImplementation(scanner);

    public static void main(String[] args) {
        while (true) {
            showMainMenu();
            int option = getIntInput("Selecciona una opción: ");

            switch (option) {
                case 1:
                    reservationSystem.showReservations();
                    break;
                case 2:
                    handleNewReservation();
                    break;
                case 3:
                    handleUpdateReservation();
                    break;
                case 4:
                    handleDeleteReservation();
                    break;
                case 5:
                    System.out.println("¡Gracias por usar nuestro sistema!");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("\n=== Sistema de Reservas de Hotel ===");
        System.out.println("1. Mostrar Reservas");
        System.out.println("2. Realizar Nueva Reserva");
        System.out.println("3. Modificar Reserva");
        System.out.println("4. Eliminar Reserva");
        System.out.println("5. Salir");
    }

    private static void handleNewReservation() {
        System.out.println("\n=== Nueva Reserva ===");

        System.out.println("Ciudades Disponibles: Medellin, Bogota, Santa Fe, Girardota");
        String city = getStringInput("Ciudad: ");
        System.out.println("Tipos Disponibles: Hotel, Apartamento, Finca, Dia de Sol");
        String type = getStringInput("Tipo de alojamiento: ");

        List<ReservationEnum> availableAccommodations =
                reservationSystem.searchAccommodations(city, type);

        if (availableAccommodations.isEmpty()) {
            System.out.println("No se encontraron alojamientos disponibles.");
            return;
        }

        System.out.println("\nAlojamientos disponibles:");
        for (ReservationEnum acc : availableAccommodations) {
            System.out.println("\n-----[ Alojamiento en " + acc.getLocation() + " ]-----");
            System.out.println("Nombre: " + acc.getName());
            System.out.println("Tipo: " + acc.getType());
            System.out.println("Rating: " + acc.getRating());
            System.out.println("Precio base: $" + acc.getPrice());
            System.out.println("Habitaciones disponibles: " + acc.getRooms().size());
            System.out.println("-------------------------------");
        }

        // Seleccionar alojamiento
        String selectedLodging = getStringInput("\nIngrese el nombre del alojamiento seleccionado: ");
        ReservationEnum selected = availableAccommodations.stream()
                .filter(a -> a.getName().equalsIgnoreCase(selectedLodging))
                .findFirst()
                .orElse(null);

        if (selected == null) {
            System.out.println("Alojamiento no válido.");
            return;
        }


        System.out.println("\nHabitaciones disponibles en " + selected.getName() + ":");
        List<Room> availableRooms = selected.getRooms();
        for (int i = 0; i < availableRooms.size(); i++) {
            System.out.println((i + 1) + ". " + availableRooms.get(i));
        }

        int selectedRoomIndex = getIntInput("Seleccione el número de la habitación: ") - 1;
        if (selectedRoomIndex < 0 || selectedRoomIndex >= availableRooms.size()) {
            System.out.println("Selección de habitación no válida.");
            return;
        }
        Room selectedRoom = availableRooms.get(selectedRoomIndex);

        Integer startDay = getIntInput("Día de inicio (1-31): ");
        Integer endDay = getIntInput("Día final (1-31): ");
        Integer totalAdults = getIntInput("Número de adultos: ");
        Integer totalKids = getIntInput("Número de niños: ");

        System.out.println("\n=== Datos del Cliente ===");
        String name = getStringInput("Nombre: ");
        String lastName = getStringInput("Apellido: ");
        String email = getStringInput("Email: ");
        String nationality = getStringInput("Nacionalidad: ");
        String phone = getStringInput("Teléfono: ");
        String arrivalTime = getStringInput("Hora de llegada: ");
        String birthDate = getStringInput("Fecha de nacimiento (DD/MM/AAAA): ");


        Client client = new Client(name, lastName, email, nationality, phone, arrivalTime, birthDate);
        ReservationData reservation = new ReservationData(
                client,
                selected,
                selectedRoom,
                startDay,
                endDay,
                totalAdults,
                totalKids
        );
        double totalPrice = reservation.calculateTotalPrice();
        System.out.println("\nResumen de la reserva:");
        System.out.println("Precio base por día: $" + selected.getPrice());
        System.out.println("Precio total de la estadía: $" + totalPrice);
        reservationSystem.createReservation(reservation);
    }

    private static void handleUpdateReservation() {
        System.out.println("\n=== Modificar Reserva ===");
        String email = getStringInput("Email del cliente: ");
        String birthDate = getStringInput("Fecha de nacimiento (DD/MM/AAAA): ");
        reservationSystem.updateReservation(email, birthDate);
    }

    private static void handleDeleteReservation() {
        System.out.println("\n=== Eliminar Reserva ===");
        String email = getStringInput("Email del cliente: ");
        String birthDate = getStringInput("Fecha de nacimiento (DD/MM/AAAA): ");
        reservationSystem.deleteReservation(email, birthDate);
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }
}