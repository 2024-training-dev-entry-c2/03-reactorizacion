import clases.*;
import java.util.*;

public class Main {

    static List<Habitacion> habitaciones = new ArrayList<>();
    static List<Alojamiento> hoteles = new ArrayList<>();
    private static List<Reserva> listaReservas = new ArrayList<>();


    public static void main(String[] args) {
        cargaInicial();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Aplicación Booking Hoteles\n");
        System.out.println("1. Buscar hoteles");
        System.out.println("2. Confirmar habitaciones disponibles");
        System.out.println("3. Reservar");
        System.out.println("4. Actualizar reserva");
        System.out.println("5. Salir");

        System.out.print("Elige una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine();

        while (opcion != 5) {
            switch (opcion) {
                case 1 -> buscarHoteles(scanner);
                case 2 -> confirmarHabitaciones(scanner);
                case 3 -> realizarReserva(scanner);
                case 4 -> actualizarReserva(scanner);
                case 5 -> System.out.println("Gracias por usar la aplicación Booking Hoteles");
                default -> System.out.println("Opción no válida");
            }
            System.out.println("Aplicación Booking Hoteles");
            System.out.println("1. Buscar hoteles ");
            System.out.println("2. Confirmar habitaciones disponibles  ");
            System.out.println("3. Reservar ");
            System.out.println("4. Actualizar reserva ");
            System.out.println("5. Salir ");

            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
        }
        scanner.close();
    }

    public static void cargaInicial() {
        habitaciones.add(new Habitacion("cama sencilla", "Sencilla", 50.0000, 2, 1));
        habitaciones.add(new Habitacion("cama doble y tv en el cuarto", "Doble", 60.0000, 2, 2));
        habitaciones.add(new Habitacion("dos camas, tv en cuarto, equipo de sonido", "Triple", 70.0000, 3, 3));
        habitaciones.add(new Habitacion("suite de lujo", "Suite de lujo", 100.0000, 2, 2));
        habitaciones.add(new Habitacion("cama individual", "Económica", 350.000, 1, 1));
        habitaciones.add(new Habitacion("habitación para familias con 3 camas", "Familiar", 850.000, 4, 2));
        habitaciones.add(new Habitacion("habitación con cama queen y oficina", "Ejecutiva", 950.000, 2, 1));
        habitaciones.add(new Habitacion("habitación con cama doble y zona de estar", "Doble con sala", 700.000, 2, 2));
        habitaciones.add(new Habitacion("habitación tipo loft con cocina", "Loft", 110.0000, 2, 1));
        habitaciones.add(new Habitacion("habitación para pareja, jacuzzi privado", "Romántica", 130.0000, 2, 1));
        habitaciones.add(new Habitacion("cabaña con vista al campo y piscina", "Finca campestre", 1200.000, 2, 2));
        habitaciones.add(new Habitacion("finca con cama rústica y chimenea", "Finca moderna", 950.000, 2, 2));
        habitaciones.add(new Habitacion("habitacion con cama de campo y porche", "Finca rústica", 800.000, 2, 2));
        habitaciones.add(new Habitacion("cabaña con vista al lago y terraza", "Día de sol familia", 150.0000, 2, 2));
        habitaciones.add(new Habitacion("bungalow con acceso directo a la zona verde", "Día de sol colonial", 200.0000, 2, 2));
        habitaciones.add(new Habitacion("suite con piscina privada", "Día de sol turistico", 250.0000, 2, 2));

        hoteles.add(new Hotel("Medellin", "Hotel Sol", 100.000, 4.5, habitaciones.subList(0, 4)));
        hoteles.add(new Apartamento("Medellin", "Apartamento Colonial", 80.000, 4.2, habitaciones.subList(5, 9)));
        hoteles.add(new Finca("Medellin", "Finca Colonial", 180.000, 3.5, habitaciones.subList(10, 13)));
        hoteles.add(new DiaSol("Medellin", "El paraiso", 230.000, true, true, 5.2, habitaciones.subList(14, 15)));
    }

    private static void buscarHoteles(Scanner scanner) {
        System.out.print("Ingrese la ciudad: ");
        String ciudad = scanner.nextLine();

        System.out.print("Ingrese el tipo de alojamiento (Hotel, Apartamento, Finca, Dia de Sol): ");
        String tipo = scanner.nextLine();

        System.out.print("Cantidad de adultos: ");
        int cantidadAdultos = scanner.nextInt();

        System.out.print("Cantidad de niños: ");
        int cantidadNiños = scanner.nextInt();

        System.out.print("Ingrese el día de inicio (01-31): ");
        int inicio = scanner.nextInt();

        System.out.print("Ingrese el día de finalización (01-31): ");
        int fin = scanner.nextInt();

        System.out.print("Ingrese la cantidad de habitaciones: ");
        int habitacionesRequeridas = scanner.nextInt();

        if (inicio > fin || inicio < 1 || fin > 31) {
            System.out.println("Fechas inválidas. Intente de nuevo.");
            return;
        }

        int dias = fin - inicio + 1;

        for (Alojamiento alojamiento : hoteles) {
            if (alojamiento.getCiudad().equalsIgnoreCase(ciudad) &&
                    alojamiento.getTipoAlojamiento().equalsIgnoreCase(tipo)) {

                double precioBase = alojamiento.getPrecioBase();
                double precioTotal = precioBase * dias * habitacionesRequeridas;

                if (fin >= 26) {
                    double aumento = precioTotal * 0.15;
                    precioTotal += aumento;
                    System.out.println("* Se aplica un aumento del 15% por hospedarse los últimos días del mes. Monto: $" + aumento);
                } else if (inicio >= 10 && inicio <= 15) {
                    double aumento = precioTotal * 0.10;
                    precioTotal += aumento;
                    System.out.println("* Se aplica un aumento del 10% por hospedarse del 10 al 15. Monto: $" + aumento);
                } else if (inicio >= 5 && inicio <= 10) {
                    double descuento = precioTotal * 0.08;
                    precioTotal -= descuento;
                    System.out.println("* Se aplica un descuento del 8% por hospedarse del 5 al 10. Monto: $" + descuento);
                }

                System.out.println(alojamiento.mostrarInformacion() + precioBase + precioTotal);
                if (alojamiento instanceof DiaSol) {
                    DiaSol diaSol = (DiaSol) alojamiento;
                    System.out.println("Incluye almuerzo: " + diaSol.isIncluirAlmuerzo());
                    System.out.println("Incluye refrigerio: " + diaSol.isIncluirRefrigerio());
                }
            }
        }
    }

    private static void confirmarHabitaciones(Scanner scanner) {
        System.out.print("Ingrese el nombre del alojamiento: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el día de inicio (01-31): ");
        int inicio = scanner.nextInt();

        System.out.print("Ingrese el día de finalización (01-31): ");
        int fin = scanner.nextInt();

        scanner.nextLine();

        if (inicio > fin || inicio < 1 || fin > 31) {
            System.out.println("Fechas inválidas. Intente de nuevo.");
            return;
        }

        for (Alojamiento alojamiento : hoteles) {
            if (alojamiento.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Habitaciones disponibles:");
                for (Habitacion habitacion : alojamiento.getHabitaciones()) {
                    int disponibilidadInicio = habitacion.getCapacidadMayores();

                    if (disponibilidadInicio < inicio || disponibilidadInicio > fin) {
                        System.out.println(habitacion.mostrarInformacion());
                    }
                }
                return;
            }
        }
        System.out.println("No se encontraron alojamientos con ese nombre.");
    }

    private static void realizarReserva(Scanner scanner) {
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese su fecha de nacimiento: ");
        String fechaNacimiento = scanner.nextLine();

        System.out.print("Ingrese su nacionalidad: ");
        String nacionalidad = scanner.nextLine();

        System.out.print("Ingrese su teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Hora de llegada (formato HH:MM): ");
        String horaLlegada = scanner.nextLine();

        System.out.print("Ingrese el nombre del alojamiento: ");
        String nombreAlojamiento = scanner.nextLine();

        System.out.print("Ingrese el día de inicio (01-31): ");
        int inicio = scanner.nextInt();

        System.out.print("Ingrese el día de finalización (01-31): ");
        int fin = scanner.nextInt();

        scanner.nextLine();

        for (Alojamiento alojamiento : hoteles) {
            if (alojamiento.getNombre().equalsIgnoreCase(nombreAlojamiento)) {
                System.out.println("Procesando reserva...");
                Cliente cliente = new Cliente(nombre, apellido, email, telefono, nacionalidad, fechaNacimiento);

                List<Habitacion> disponibles = new ArrayList<>();
                for (Habitacion habitacion : alojamiento.getHabitaciones()) {
                    int disponibilidadInicio = habitacion.getCapacidadMayores();
                    if (disponibilidadInicio < inicio || disponibilidadInicio > fin) {
                        disponibles.add(habitacion);
                    }
                }

                if (disponibles.isEmpty()) {
                    System.out.println("No hay habitaciones disponibles para las fechas seleccionadas.");
                    return;
                }

                System.out.println("Seleccione una habitación para reservar:");
                for (int i = 0; i < disponibles.size(); i++) {
                    System.out.printf("%d. %s\n", i + 1, disponibles.get(i).mostrarInformacion());
                }

                System.out.print("Ingrese el número de la habitación seleccionada: ");
                int seleccion = scanner.nextInt();

                if (seleccion < 1 || seleccion > disponibles.size()) {
                    System.out.println("Selección inválida.");
                    return;
                }

                Habitacion habitacionSeleccionada = disponibles.get(seleccion - 1);
                alojamiento.getHabitaciones().remove(habitacionSeleccionada);

                Reserva<Object> nuevaReserva = new Reserva<>(cliente, nombreAlojamiento, habitacionSeleccionada, 4, String.valueOf(inicio), String.valueOf(fin), horaLlegada);
                ReservaImplementacion reservaImplementacion = new ReservaImplementacion(nuevaReserva);
                reservaImplementacion.confirmarReserva();

                System.out.println("Habitación reservada: " + habitacionSeleccionada.mostrarInformacion());
                System.out.println("Reserva realizada exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró el alojamiento.");
    }

    private static void actualizarReserva(Scanner scanner) {
        System.out.print("Ingrese el correo registrado: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese su fecha de nacimiento (año-mes-dia): ");
        String fechaNacimiento = scanner.nextLine();

        Reserva reserva = buscarReservaPorEmailYFecha(email, fechaNacimiento);
        if (reserva == null) {
            System.out.println("No se encontró una reserva con los datos proporcionados.");
            return;
        }

        System.out.println("Autenticación exitosa.");
        System.out.println("¿Desea cambiar habitación o alojamiento? (1: Habitación, 2: Alojamiento)");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            cambiarHabitacion(reserva, scanner);
        } else if (opcion == 2) {
            cambiarAlojamiento(reserva, scanner);
        } else {
            System.out.println("Opción inválida.");
        }
    }

    private static Reserva buscarReservaPorEmailYFecha(String email, String fechaNacimiento) {
        for (Reserva reserva : listaReservas) {
            if (reserva.getCliente().getEmail().equalsIgnoreCase(email) &&
                    reserva.getCliente().getFechaNacimiento().equals(fechaNacimiento)) {
                return reserva;
            }
        }
        return null;
    }

    private static void cambiarHabitacion(Reserva reserva, Scanner scanner) {
        System.out.println("Habitación actual:");
        System.out.println(reserva.getHabitacion().mostrarInformacion());

        System.out.println("Habitaciones disponibles:");
        List<Habitacion> disponibles = new ArrayList<>();
        for (Habitacion habitacion : ((Alojamiento) reserva.getAlojamiento()).getHabitaciones()) {
            if (!habitacion.equals(reserva.getHabitacion())) {
                disponibles.add(habitacion);
                System.out.printf("%d. %s\n", disponibles.size(), habitacion.mostrarInformacion());
            }
        }
        if (disponibles.isEmpty()) {
            System.out.println("No hay otras habitaciones disponibles.");
            return;
        }
        System.out.print("Seleccione una nueva habitación: ");
        int seleccion = scanner.nextInt();

        if (seleccion < 1 || seleccion > disponibles.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Habitacion nuevaHabitacion = disponibles.get(seleccion - 1);
        reserva.setHabitacion(nuevaHabitacion);

        System.out.println("Habitación cambiada exitosamente.");
        ReservaImplementacion reservaImpl = new ReservaImplementacion(reserva);
    }

    private static void cambiarAlojamiento(Reserva reserva, Scanner scanner) {
        System.out.println("Se cancelará la reserva actual.");
        listaReservas.remove(reserva);
        System.out.println("Reserva cancelada. Por favor, realice una nueva reserva.");
        realizarReserva(scanner);
    }




}


