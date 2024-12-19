import LogicaDeNegocios.FiltroAlojamiento;
import LogicaDeNegocios.FiltroHabitacion;
import LogicaDeNegocios.FiltroReservas;
import alojamientos.*;
import clientes.ClienteData;
import habitaciones.Habitacion;
import reservas.ReservaData;
import reservas.ReservaImplementation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Alojamiento> alojamientos = new ArrayList<>();
    static ReservaImplementation reserva = new ReservaImplementation();
    static FiltroReservas filtroReservas = new FiltroReservas();
    static FiltroAlojamiento filtroAlojamiento = new FiltroAlojamiento();
    static FiltroHabitacion filtroHabitacion = new FiltroHabitacion();
    public static void inicializarDatos() {

        DiaDeSolData diaDeSol1 = new DiaDeSolData("Yoga al aire libre, Piscina", "Refrigerio, Almuerzo", 50000.0);
        DiaDeSolData diaDeSol2 = new DiaDeSolData("Clases de surf, Bicicletas disponibles", "Desayuno, Almuerzot", 80000.0);
        DiaDeSolData diaDeSol3 = new DiaDeSolData("Senderismo, Paseos a caballo", "Desayuno incluido", 80.0);
        DiaDeSolData diaDeSol4 = new DiaDeSolData("Piscina natural, Yoga matutino", "Almuerzo orgánico", 120.0);

        Hotel hotel1 = new Hotel("hotel sol radiante", "cartagena", 4.5, "Un hotel con vistas al mar", diaDeSol1, true);
        Hotel hotel2 = new Hotel("cielo esplendido", "cartagena", 4.8, "Un refugio en las montañas", diaDeSol2, false);
        Hotel hotel3 = new Hotel("ciudad moderna", "santa marta", 4.2, "Un hotel en el corazón de la ciudad");

        Finca finca1 = new Finca("Finca La Esperanza", "santa marta", 4.7, "Un lugar para relajarse en la naturaleza", diaDeSol3);
        Finca finca2 = new Finca("Finca Las Flores", "cartagena", 4.9, "Una finca con hermosos paisajes", diaDeSol4);
        Finca finca3 = new Finca("Finca El Refugio", "santa marta", 4.5, "Una finca para disfrutar del campo colombiano");

        Apartamento apartamento1 = new Apartamento("apartamento vista al mar", "cartagena", 4.6, "Apartamento con balcón y vista al mar", 10, "1001");
        Apartamento apartamento2 = new Apartamento("apartamento moderno", "cartagena", 4.8, "Moderno apartamento en el centro", 5, "502");
        Apartamento apartamento3 = new Apartamento("apartamento familiar", "santa marta", 4.3, "Ideal para familias, cerca del metro", 2, "201");

        ArrayList<Habitacion> habitacionesHotel = crearHabitaciones();
        hotel1.setHabitaciones(habitacionesHotel);
        hotel2.setHabitaciones(habitacionesHotel);
        hotel3.setHabitaciones(habitacionesHotel);

        ArrayList<Habitacion> habitacionesFinca = crearHabitaciones();
        finca1.setHabitaciones(habitacionesFinca);
        finca2.setHabitaciones(habitacionesFinca);
        finca3.setHabitaciones(habitacionesFinca);

        ArrayList<Habitacion> habitacionesApartamento = crearHabitaciones();
        apartamento1.setHabitaciones(habitacionesApartamento);
        apartamento2.setHabitaciones(habitacionesApartamento);
        apartamento3.setHabitaciones(habitacionesApartamento);

        alojamientos.add(hotel1);
        alojamientos.add(hotel2);
        alojamientos.add(hotel3);
        alojamientos.add(finca1);
        alojamientos.add(finca2);
        alojamientos.add(finca3);
        alojamientos.add(apartamento1);
        alojamientos.add(apartamento2);
        alojamientos.add(apartamento3);
    }


    public static ArrayList<Habitacion> crearHabitaciones() {
        ArrayList<Habitacion> habitaciones = new ArrayList<>();

        habitaciones.add(new Habitacion("estandar", "Habitación básica con baño privado", 2, 10, 100000.0));
        habitaciones.add(new Habitacion("deluxe", "Habitación amplia con balcón", 3, 5, 150000.0));
        habitaciones.add(new Habitacion("suite", "Habitación de lujo con jacuzzi", 4, 2, 300000.0));
        habitaciones.add(new Habitacion("familiar", "Habitación con capacidad para toda la familia", 6, 3, 250000.0));
        habitaciones.add(new Habitacion("economica", "Habitación pequeña a buen precio", 1, 15, 80000.0));

        return habitaciones;
    }

    public static void main(String[] args) {
        inicializarDatos();
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
        String tipoAlojamiento = scanner.nextLine();

        System.out.print("Ingrese el mes de inicio del hospedaje: ");
        int mesInicio = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el dia de inicio del hospedaje: ");
        int diaInicio = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el mes de finalizacion del hospedaje: ");
        int mesfinalizacion = scanner.nextInt();
        scanner.nextLine();

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

        filtroAlojamiento.buscarAlojamientos(ciudad, tipoAlojamiento, diaInicio, diaFinalizacion,numHabitaciones,alojamientos);
    }

    public static void formularioConfirmacionHabitaciones() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del hotel: ");
        String nombreHotel = scanner.nextLine();

        System.out.print("Ingrese el mes de inicio del hospedaje: ");
        int mesInicio = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el dia de inicio del hospedaje: ");
        int diaInicio = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el mes de finalizacion del hospedaje: ");
        int mesfinalizacion = scanner.nextInt();
        scanner.nextLine();

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

       filtroHabitacion.confirmarHabitaciones(nombreHotel, numHabitaciones, alojamientos);

    }

    public static void formularioReserva() {
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

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

        System.out.print("Introduce la fecha de inicio (dd-MM-yyyy): ");
        String fechaInicioStr = scanner.nextLine();
        LocalDate fechaInicio = LocalDate.parse(fechaInicioStr,formatter);


        System.out.print("Introduce la fecha de fin (dd-MM-yyyy): ");
        String fechaFinStr = scanner.nextLine();
        LocalDate fechaFin = LocalDate.parse(fechaFinStr,formatter);

        System.out.print("Ingrese su hora aproximada de llegada: ");
        String horaLlegada = scanner.nextLine();

        System.out.print("Ingrese el nombre del alojamiento: ");
        String alojamiento = scanner.nextLine();

        System.out.print("Ingrese su fecha de nacimiento: ");
        String fechaNacimiento = scanner.nextLine();

        int tipoHabitacion = 0;
        System.out.print("Ingrese el tipo de habitacion que busca (estandar[0], deluxe[1], suite2], familiar[3], economical[4]: ");
        tipoHabitacion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la cantidad de habitaciones: ");
        int cantidadHabitaciones = scanner.nextInt();
        scanner.nextLine();

        ClienteData cliente = new ClienteData(nombre,apellido,fechaNacimiento,telefono,email, nacionalidad);
        Alojamiento AlojamientoTemporal=filtroReservas.encontrarAlojamiento(alojamientos,alojamiento);
        ReservaData reservaData = new ReservaData(AlojamientoTemporal,cliente,fechaInicio,fechaFin,horaLlegada,alojamientos.get(0).getHabitaciones().get(0),cantidadHabitaciones);
        reserva.agregarReserva(reservaData);
    }

    public static void actualizarReserva() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese su fecha de nacimiento: ");
        String fechaNacimiento = scanner.nextLine();
        reserva.mostrarReserva(email,fechaNacimiento);
        System.out.print("Quiere un cambio de habitacion[0] o de alojamiento[1]: ");
        int cambioReserva = scanner.nextInt();
        scanner.nextLine();

        if(cambioReserva==1){
            reserva.eliminarReserva(reserva.getReservas().get(reserva.getIndice()));
            formularioReserva();
        }else if(cambioReserva==0){
            filtroReservas.acomodarReserva(reserva.getReservas().get(reserva.getIndice()));
        }

    }


}