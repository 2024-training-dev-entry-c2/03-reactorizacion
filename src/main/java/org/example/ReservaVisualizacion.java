package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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

    public void autenticarReserva(Scanner scanner, String email, LocalDate fechaNacimiento) {
        Iterator<ReservaImplementation> iterator = reservas.iterator();

        while (iterator.hasNext()) {
            ReservaImplementation reserva = iterator.next();

            if (reserva.getReservaData().getCliente().getEmail().equalsIgnoreCase(email) &&
                    reserva.getReservaData().getCliente().getFechaNacimiento().equals(fechaNacimiento)) {

                mostrarReserva(reserva.getReservaData());
                System.out.println("1. Cambiar habitación");
                System.out.println("2. Cancelar reserva");

                int opcion = MenuHelper.obtenerEntradaValida(scanner, 2) + 1;

                switch (opcion) {
                    case 1 -> cambiarHabitacion(scanner, reserva); // Verifica si esta operación modifica `reservas`.
                    case 2 -> {
                        iterator.remove(); // Elimina la reserva de manera segura.
                        cancelarReserva(reserva);
                    }
                    default -> System.out.println("Opción inválida.");
                }
            }
        }
    }

    public void cancelarReserva(ReservaImplementation reserva) {
        reservas.remove(reserva);
       if (reserva.cancelarReserva(reserva.getReservaData().getHabitacion())){
           System.out.println("Porfavor vuelva a hacer la reserva");
       };

    }

    public void cambiarHabitacion(Scanner scanner, ReservaImplementation reserva) {
        Alojamientos alojamientoActual = (Alojamientos) reserva.getReservaData().getAlojamiento();
        List<Habitacion> habitaciones = alojamientoActual.getHabitaciones();
        int habitacionIndex = MenuHelper.seleccionarOpcion(scanner, "Selecciona una nueva habitación:",
                habitaciones.stream().map(Habitacion::getTipo).toList());
        Habitacion nuevaHabitacion = habitaciones.get(habitacionIndex);
        reserva.actualizarReserva(nuevaHabitacion);
    }


    private void mostrarReserva(ReservaData reservaData) {
        System.out.println("-----------------------------------------------------");
        System.out.println("Datos de la reserva:");
        System.out.println("Nombre: " + reservaData.getCliente().getNombre() + " ");
        System.out.println("Email: " + reservaData.getCliente().getEmail());
        System.out.println("Nacionalidad: " + reservaData.getCliente().getNacionalidad());
        System.out.println("Teléfono: " + reservaData.getCliente().getNacionalidad());
        System.out.println("Hotel: " + reservaData.getAlojamiento());
        System.out.println("Habitación: " + reservaData.getHabitacion().getTipo());
        System.out.println("-----------------------------------------------------");
    }


}
