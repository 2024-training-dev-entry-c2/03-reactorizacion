import Services.BookingServices;
import lib.MenuOptionEnum;

import java.util.InputMismatchException;
import java.util.Scanner;

import static lib.MenuOptionEnum.getMenuOption;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BookingServices bookingServices = new BookingServices();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();

            try {
                int choice = getUserChoice();
                running = handleMenuOption(choice);
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                scanner.nextLine();
            }
        }
    }

    private static void printMenu() {
        System.out.println("----- Sistema de Reservas -----");
        System.out.println("1. Buscar Alojamientos");
        System.out.println("2. Buscar Habitaciones");
        System.out.println("3. Reservar");
        System.out.println("4. Modificar Reserva");
        System.out.println("5. Salir");
        System.out.print("Ingresa una opción: ");
    }

    private static int getUserChoice() {
        return scanner.nextInt();
    }

    private static boolean handleMenuOption(int choice) {
        MenuOptionEnum option = getMenuOption(choice);

        if (option != null) {
            switch (option) {
                case SEARCH_ACCOMMODATION -> bookingServices.searchAccommodation();
                case SEARCH_ROOMS -> bookingServices.searchAndConfirmRoom(scanner);
                case RESERVE -> bookingServices.confirmReservation();
//                case MODIFY_RESERVATION -> bookingServices.modifyAccommodation(scanner);
                case EXIT -> {
                    System.out.println("Saliendo del sistema. ¡Gracias por usar el sistema de reservas!");
                    return false;
                }
                default -> System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }
        }
        return true;
    }
}