import java.util.*;

public class BookingSystem {
    private static ControllerImplementation controller = new ControllerImplementation();
    private static boolean canReserve = false;
    private static boolean canConfirm = false;
    private static int bookingIndex = 0;
    private static int userIndex = 0;
    private static Booking newBooking;


    private static String setAccommodationFilteringData(Scanner scanner){
        System.out.print("Ciudad: ");
        String city = scanner.nextLine();
        System.out.println("Tipo de alojamiento:");
        System.out.println("1. Hotel");
        System.out.println("2. Apartamento");
        System.out.println("3. Finca");
        System.out.println("4. Día de sol");
        System.out.print("Seleccione una opción: ");
        Integer selectedType = scanner.nextInt();
        String type = "";
        switch (selectedType) {
            case 1 -> type = "Hotel";
            case 2 -> type = "Apartment";
            case 3 -> type = "Farm";
            case 4 -> type = "Sunny Day";
        }
        Integer start;
        Integer end = 0;
        Integer roomQuantity = 0;
        if(type.equals("Sunny Day")){
            System.out.print("Fecha: ");
            start = scanner.nextInt();
        }
        else{
            System.out.print("Fecha de inicio: ");
            start = scanner.nextInt();
            System.out.print("Fecha de fin: ");
            end = scanner.nextInt();
            System.out.print("Cantidad de habitaciones: ");
            roomQuantity = scanner.nextInt();
        }
        System.out.print("Cantidad de adultos: ");
        Integer adultsQuantity = scanner.nextInt();
        System.out.print("Cantidad de niños: ");
        Integer childrenQuantity = scanner.nextInt();
        scanner.nextLine();
        newBooking = new Booking(start,end,adultsQuantity,childrenQuantity,roomQuantity,type,city);
        return type;
    }


    public static void showFilteredAccommodations(Scanner scanner, String type){
        controller.filterAccommodations(newBooking);
        ArrayList<Accommodation> selectedAccommodations = controller.getSelectedAccommodations();

        if (selectedAccommodations.isEmpty()) {
            System.out.println("No se encontraron alojamientos disponibles según los criterios ingresados.");
        } else {
            System.out.println("\nAlojamientos encontrados:\n");
            int number = 1;
            for (Accommodation accommodation : selectedAccommodations) {
                System.out.println(number+". "+ accommodation.getName());
                System.out.println(accommodation.showAccommodation(newBooking));
                number++;
            }
            System.out.print("Seleccione una opción: ");
            int accOption = scanner.nextInt();
            if(accOption > 0 && accOption <= selectedAccommodations.size()){
                Accommodation acc= selectedAccommodations.get(accOption-1);
                newBooking.setAccommodation(acc.getName());
                if(type.equals("Hotel")){
                    canConfirm = true;
                }
                else{
                    newBooking.setFinalPrice(acc.getPriceDetail().getFinalPrice());
                    canReserve = true;
                }
                System.out.println("Alojamiento seleccionado: "+acc.getName());
            }
            else{
                newBooking = null;
                System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    public static void main(String[] args) {
        controller.loadData();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSistema de Reservas");
            System.out.println("1. Buscar alojamiento");
            System.out.println("2. Confirmar habitaciones (hoteles)");
            System.out.println("3. Realizar reserva");
            System.out.println("4. Actualizar reserva");
            System.out.println("0. Salir\n");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1 -> {
                    String type = setAccommodationFilteringData(scanner);
                    showFilteredAccommodations(scanner, type);
                }


                case 0 -> {
                    System.out.println("Gracias por usar el sistema. Adiós!");
                    exit = true;
                }
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}