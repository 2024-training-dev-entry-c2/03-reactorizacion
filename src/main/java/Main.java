
import Services.BookingServices;
import lib.MenuOptionEnum;


import java.util.*;

import static Services.BookingServices.searchAccommodation;
import static Services.BookingServices.searchAndConfirmRoom;
import Services.BookingServices.*;

import static lib.MenuOptionEnum.getMenuOption;


public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("----- Sistema de Reservas -----");
            System.out.println("1. Buscar Alojamientos");
            System.out.println("2. Buscar Habitaciones");
            System.out.println("3. Reservar");
            System.out.println("4. Modificar Reserva");
            System.out.println("5. Salir");
            System.out.print("Ingresa una opción: ");
            int choice = 0;

            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error: " +e);
                scanner.nextLine();
            }

            MenuOptionEnum option = getMenuOption(choice);

            if (option.equals(MenuOptionEnum.SEARCH_ACCOMMODATION)) {
                searchAccommodation(scanner);
            }
            else if (option.equals(MenuOptionEnum.SEARCH_ROOMS)) {
                searchAndConfirmRoom();
            }
            else if (option.equals(MenuOptionEnum.RESERVE)) {
                BookingServices bookingServices = new BookingServices();
                bookingServices.confirmReservation();
            }
            else if (option.equals(MenuOptionEnum.MODIFY_RESERVATION)) {
                BookingServices bookingServices = new BookingServices();
//                bookingServices.modifyReservation();
            }
            else if (choice == 5) {
                break;
            }
            else {
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
}


