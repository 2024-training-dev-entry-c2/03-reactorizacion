package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReservaVisualizacion {
    private List<ReservaImplementation> reservas = new ArrayList<>();

    public boolean crearReserva(String nombre, String apellido, String nacionalidad, String email, LocalDate fechaNacimiento, Alojamientos alojamiento, Habitacion habitacion, float telefono, LocalDate fechaInicio, LocalDate fechaSalida) {
        Cliente cliente = new Cliente(nombre, apellido, nacionalidad, telefono, email, fechaNacimiento);
        ReservaImplementation reservacion = new ReservaImplementation();
        boolean reservaExitosa = reservacion.reservar(cliente, alojamiento, habitacion, fechaInicio, fechaSalida);
        if (reservaExitosa) {
            mostrarReservacion(reservacion.getReservaData());
            reservas.add(reservacion);
        }
        return reservaExitosa;
    }

    private void mostrarReservacion(ReservaData reservaData) {
        Cliente cliente = reservaData.getCliente();
        Habitacion habitacion = reservaData.getHabitacion();
        Alojamientos alojamientos = (Alojamientos) reservaData.getAlojamiento();
        String detalles = """
                -----------------------------------------------------
                ¡Reserva realizada con éxito!
                Datos de la reserva:
                Nombre: %s
                Email: %s
                Nacionalidad: %s
                Teléfono: %s
                
                Hotel: %s
                Habitación: %s
                -----------------------------------------------------
                """.formatted(cliente.getNombre(), cliente.getEmail(), cliente.getNacionalidad(), cliente.getTelefono(), alojamientos.getNombre(), habitacion.getTipo());
        System.out.println(detalles);

    }

    public ReservaImplementation autenticarReserva(Scanner scanner, String email, LocalDate fechaNacimiento) {
        for (ReservaImplementation reserva : reservas) {
            if (reserva.getReservaData().getCliente().getEmail().equalsIgnoreCase(email) &&
                    reserva.getReservaData().getCliente().getFechaNacimiento().equals(fechaNacimiento)) {

                System.out.println("1. Cambiar habitación");
                System.out.println("2. Cancelar reserva");

                int opcion = obtenerEntradaValida(scanner, 2);
                System.out.println(opcion);

                switch (opcion) {
                    case 1 -> cambiarHabitacion(scanner, reserva);
                    case 2 -> cancelarReserva(reserva);
                    default -> System.out.println("Opción inválida.");
                }
            }
        }
        return null;
    }

    public void cancelarReserva(ReservaImplementation reserva) {
        reservas.remove(reserva);
        reserva.cancelarReserva(reserva.getReservaData().getHabitacion());

    }

    public void cambiarHabitacion(Scanner scanner, ReservaImplementation reserva) {
        Alojamientos alojamientoActual = (Alojamientos) reserva.getReservaData().getAlojamiento();
        List<Habitacion> habitaciones = alojamientoActual.getHabitaciones();
        int habitacionIndex = seleccionarOpcion(scanner, "Selecciona una nueva habitación:",
                habitaciones.stream().map(Habitacion::getTipo).toList());
        Habitacion nuevaHabitacion = habitaciones.get(habitacionIndex);
        reserva.actualizarReserva(nuevaHabitacion);
    }

    private int seleccionarOpcion(Scanner scanner, String mensaje, List<String> opciones) {
        System.out.println(mensaje);
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i));
        }
        System.out.println((opciones.size() + 1) + ". Volver");
        return obtenerEntradaValida(scanner, opciones.size());
    }

    static private int obtenerEntradaValida(Scanner scanner, int maxOption) {
        int opcion;
        while (true) {
            System.out.print("Ingrese un número: ");
            try {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= maxOption) {
                    return opcion ;
                } else if (opcion == maxOption + 1) {
                    return -1;
                } else {
                    System.out.println("Por favor, ingrese un número válido.");
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
            }
        }
    }


}
