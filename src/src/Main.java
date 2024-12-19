import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Buscar Alojamientos");
            System.out.println("2. Confirmar habitaciones en un hotel");
            System.out.println("3. Reservar");
            System.out.println("4. actualizar reserva");
            System.out.println("5. salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    formularioBuscarAlojamientos();
                    break;
                case 2:
                    formularioConfirmacionHabitaciones();
                    break;
                case 3:
                    formularioReserva();
                    break;
                case 4:
                    actualizarReserva();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
            System.out.println();
        } while (opcion != 5);

        scanner.close();
    }

    public static void formularioBuscarAlojamientos() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("En que ciudad quiere buscar alojamiento?: ");
        String ciudad = scanner.nextLine();

        System.out.print("Que tipo de alojamiento busca? (hotel, apartamento, finca, dia de sol): ");
        String alojamiento = scanner.nextLine();

        System.out.print("Ingrese el mes de inicio del hospedaje: ");
        int mesInicio = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese el dia de inicio del hospedaje: ");
        int diaInicio = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese el mes de finalizacion del hospedaje: ");
        int mesfinalizacion = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese el dia de finalización del hospedaje : ");
        int diaFinalizacion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la cantidad de adultos: ");
        int cantAdultos = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la cantidad de niños: ");
        int cantNinos = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el numero de habitaciones que busca: ");
        int numHabitaciones = scanner.nextInt();
        scanner.nextLine();

        System.out.println("-------------------");

        //buscarHoteles(ciudad, alojamiento, mesInicio, diaInicio, mesfinalizacion, diaFinalizacion, cantAdultos, cantNinos,numHabitaciones);
    }

    public static void formularioConfirmacionHabitaciones() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del hotel: ");
        String nombreHotel = scanner.nextLine();

        System.out.print("Ingrese el mes de inicio del hospedaje: ");
        int mesInicio = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese el dia de inicio del hospedaje: ");
        int diaInicio = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese el mes de finalizacion del hospedaje: ");
        int mesfinalizacion = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese el dia de finalización del hospedaje : ");
        int diaFinalizacion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la cantidad de adultos: ");
        int cantAdultos = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la cantidad de niños: ");
        int cantNinos = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el numero de habitaciones que busca: ");
        int numHabitaciones = scanner.nextInt();
        scanner.nextLine();

        //ConfirmarHabitaciones(nombreHotel, mesInicio, diaInicio, mesfinalizacion, diaFinalizacion, cantAdultos, cantNinos, numHabitaciones);

    }

    public static void formularioReserva() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Formulario de Reserva ===");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese su nacionalidad: ");
        String nacionalidad = scanner.nextLine();

        System.out.print("Ingrese su número de teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese el mes de inicio del hospedaje: ");
        int mesInicio = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese el dia de inicio del hospedaje: ");
        int diaInicio = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese el mes de finalizacion del hospedaje: ");
        int mesfinalizacion = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese el dia de finalización del hospedaje : ");
        int diaFinalizacion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese su hora aproximada de llegada: ");
        String horaLlegada = scanner.nextLine();

        System.out.print("Ingrese el nombre del alojamiento: ");
        String alojamiento = scanner.nextLine();

        System.out.print("Ingrese su fecha de nacimiento: ");
        String fechaNacimiento = scanner.nextLine();

        int tipoHabitacion = 0;
        System.out.print("Ingrese el tipo de habitacion que busca (sencilla[0], doble[1], gold[2], premium[3], suite presidencial[4]/penthouse[4]/suite[4]/vip[4]): ");
        tipoHabitacion = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese la cantidad de habitaciones: ");
        int cantidadHabitaciones = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        //reservarHabitacion(nombre, apellido, email, nacionalidad, telefono, mesInicio, diaInicio, mesfinalizacion, diaFinalizacion, horaLlegada,fechaNacimiento ,alojamiento, tipoHabitacion, cantidadHabitaciones);

    }

    public static void actualizarReserva() {
        Scanner scanner = new Scanner(System.in);

        // Solicitar los datos para identificar la reserva
        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese su fecha de nacimiento (dd/mm/yyyy): ");
        String fechaNacimiento = scanner.nextLine();

    }


}