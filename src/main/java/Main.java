import Services.BookingServices;
import lib.MenuOptionEnum;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

import static lib.MainUtils.printMenu;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BookingServices bookingServices = new BookingServices(scanner);
    private static final Map<MenuOptionEnum, Consumer<BookingServices>> menuActions = new HashMap<>();

    static {
        menuActions.put(MenuOptionEnum.SEARCH_ACCOMMODATION, BookingServices::searchAccommodation);
        menuActions.put(MenuOptionEnum.SEARCH_ROOMS, BookingServices::searchAndConfirmRoom);
        menuActions.put(MenuOptionEnum.RESERVE, BookingServices::confirmReservation);
        menuActions.put(MenuOptionEnum.MODIFY_RESERVATION, BookingServices::changeReservation);
        menuActions.put(MenuOptionEnum.EXIT, BookingServices::handleExitOption);
    }

    public static void main(String[] args) {
        Boolean running = true;

        while (running) {
            printMenu();
            try {
                Integer choice = getUserChoice();
                running = handleMenuOption(choice);
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                scanner.nextLine();
            }
        }
    }

    private static Integer getUserChoice() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                scanner.nextLine();
            }
        }
    }

    private static boolean handleMenuOption(Integer choice) {
        scanner.nextLine();
        MenuOptionEnum option = MenuOptionEnum.getMenuOption(choice);

        if (option == null) {
            System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            return true;
        }

        menuActions.getOrDefault(option, services ->
          System.out.println("Acción no implementada para esta opción.")
        ).accept(bookingServices);

        return option != MenuOptionEnum.EXIT;
    }

}