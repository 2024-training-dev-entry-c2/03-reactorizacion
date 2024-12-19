package modelos;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class FiltroHabitacion {

    public static void verificarCantidadHabitaciones(Alojamiento alojamientoElegido, int habitacionesSolicitadas) {

        int totalHabitacionesDisponibles = 0;
        for (int j = 0; j < alojamientoElegido.getHabitacion().size(); j++) {
            totalHabitacionesDisponibles += alojamientoElegido.getHabitacion().get(j).getHabitacionesDisponibles();
        }
        if (totalHabitacionesDisponibles < habitacionesSolicitadas) {
            System.out.println("No hay suficientes habitaciones disponibles para la cantidad solicitada.");
            return;
        }
        System.out.println("Tipos de habitaciones disponibles en " + alojamientoElegido.getNombreAlojamiento() + ":");
        alojamientoElegido.mostrarHabitacionesDisponibles();
    }

    public static String[] seleccionarHabitaciones (Alojamiento alojamientoElegido, int cantidadHabitaciones) {
        Scanner scanner = new Scanner(System.in);
        String[] habitacionesSeleccionadas = new String[cantidadHabitaciones];

        System.out.println("¿Desea continuar con la reserva? (Por favor digite Si o No)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("Si")) {
            System.out.println("Tipos de habitaciones disponibles:");
            for (int i = 0; i < alojamientoElegido.getHabitacion().size(); i++) {
                System.out.println((i + 1) + ". " + alojamientoElegido.getHabitacion().get(i).getTiposDeHabitaciones());
            }

            for (int i = 0; i < cantidadHabitaciones; i++) {
                System.out.println("Seleccione el tipo de habitación #" + (i + 1) + ":");
                int habitacionSeleccionada = scanner.nextInt();
                scanner.nextLine();

                if (habitacionSeleccionada < 1 || habitacionSeleccionada > alojamientoElegido.getHabitacion().size()) {
                    System.out.println("Opción no válida. Intente de nuevo.");
                    i--;
                    continue;
                }
                habitacionesSeleccionadas[i] = alojamientoElegido.getHabitacion().get( habitacionSeleccionada - 1).getTiposDeHabitaciones();

                int habitacionesDisponibles = alojamientoElegido.getHabitacion().get( habitacionSeleccionada - 1).getHabitacionesDisponibles();

                alojamientoElegido.getHabitacion().get( habitacionSeleccionada - 1).setHabitacionesDisponibles(habitacionesDisponibles - 1);;
                System.out.println("Habitaciones disponibles actualizadas: " + alojamientoElegido.getHabitacion().get( habitacionSeleccionada - 1).getHabitacionesDisponibles());
            }
        } else {
            System.out.println("La reserva no se realizo.");
        } return habitacionesSeleccionadas;
    }
}