import Services.BookingServices;
import constants.MenuOptionEnum;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static lib.MainUtils.getUserChoice;
import static lib.MainUtils.printMenu;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BookingServices bookingServices = BookingServices.getInstance(scanner);
    private static final Map<MenuOptionEnum, Runnable> menuActions = new HashMap<>();

    static {
        menuActions.put(MenuOptionEnum.SEARCH_ACCOMMODATION, bookingServices::searchAccommodation);
        menuActions.put(MenuOptionEnum.SEARCH_ROOMS, bookingServices::searchAndConfirmRoom);
        menuActions.put(MenuOptionEnum.RESERVE, bookingServices::confirmReservation);
        menuActions.put(MenuOptionEnum.MODIFY_RESERVATION, bookingServices::changeReservation);
        menuActions.put(MenuOptionEnum.EXIT, bookingServices::handleExitOption);
    }

    public static void main(String[] args) {
        Boolean running = true;

        while (running) {
            printMenu();
            try {
                Integer choice = getUserChoice(scanner);
                running = handleMenuOption(choice);
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                scanner.nextLine();
            }
        }
    }

    private static Boolean handleMenuOption(Integer choice) {
        scanner.nextLine();
        MenuOptionEnum option = getValidatedMenuOption(choice);

        executeMenuAction(option);
        return !isExitOption(option);
    }

    private static MenuOptionEnum getValidatedMenuOption(Integer choice) {
        MenuOptionEnum option = MenuOptionEnum.getMenuOption(choice);
        if (option == null) {
            System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
        }
        return option;
    }

    private static void executeMenuAction(MenuOptionEnum option) {
        if (option == null) return;

        menuActions.getOrDefault(option,  ()->
          System.out.println("Acción no implementada para esta opción.")
        ).run();
    }

    private static Boolean isExitOption(MenuOptionEnum option) {
        return option == MenuOptionEnum.EXIT;
    }
}