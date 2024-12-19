package org.example;

import org.example.data.Data;
import org.example.models.Alojamiento;
import org.example.models.Cliente;
import org.example.services.ReservaImplementacion;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Crear Reserva");
            System.out.println("2. Mostrar Reservas");
            System.out.println("3. Actualizar Reserva");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> crearReserva(scanner);
                case 2 -> mostrarReservas();
                case 3 -> actualizarReserva(scanner);
                case 4 -> {
                    System.out.println("¡Gracias por usar el sistema de reservas!");
                    return;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private static void crearReserva(Scanner scanner) {
        System.out.println("Ingrese los datos del cliente:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());

        Cliente cliente = new Cliente(nombre, apellido, email, nacionalidad, telefono, fechaNacimiento);

        System.out.println("Seleccione un alojamiento:");
        for (int i = 0; i < Data.propiedades.size(); i++) {
            System.out.println((i + 1) + ". " + Data.propiedades.get(i).getNombre());
        }
        int opcionAlojamiento = scanner.nextInt();
        scanner.nextLine();

        Alojamiento alojamiento = Data.propiedades.get(opcionAlojamiento - 1);

        System.out.print("Ingrese el tipo de habitación: ");
        String tipoHabitacion = scanner.nextLine();
        System.out.print("Fecha de inicio (YYYY-MM-DD): ");
        LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());
        System.out.print("Fecha de fin (YYYY-MM-DD): ");
        LocalDate fechaFin = LocalDate.parse(scanner.nextLine());

        ReservaImplementacion reserva = new ReservaImplementacion(null, null, null, null, null);
        try {
            reserva.crearReserva(cliente, alojamiento, tipoHabitacion, fechaInicio, fechaFin);
            Data.reservas.add(reserva);
            System.out.println("Reserva creada con éxito.");
        } catch (Exception e) {
            System.out.println("Error al crear la reserva: " + e.getMessage());
        }
    }

    private static void mostrarReservas() {
        if (Data.reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
            return;
        }
        System.out.println("\n--- Reservas Registradas ---");
        for (ReservaImplementacion reserva : Data.reservas) {
            reserva.mostrarReserva();
        }
    }

    private static void actualizarReserva(Scanner scanner) {
        if (Data.reservas.isEmpty()) {
            System.out.println("No hay reservas para actualizar.");
            return;
        }

        System.out.println("\n--- Actualizar Reserva ---");
        System.out.print("Ingrese el email del cliente: ");
        String email = scanner.nextLine();

        ReservaImplementacion reserva = Data.reservas.stream()
                .filter(r -> r.getCliente().getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);

        if (reserva == null) {
            System.out.println("Reserva no encontrada para el email proporcionado.");
            return;
        }

        System.out.println("¿Qué desea actualizar?");
        System.out.println("1. Cambiar habitación");
        System.out.println("2. Cambiar alojamiento");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 1) {
            System.out.print("Ingrese el nuevo tipo de habitación: ");
            String nuevoTipoHabitacion = scanner.nextLine();
            try {
                reserva.actualizarReserva(reserva.getCliente(), nuevoTipoHabitacion);
            } catch (Exception e) {
                System.out.println("Error al actualizar la reserva: " + e.getMessage());
            }
        } else if (opcion == 2) {
            System.out.println("La reserva será eliminada. Cree una nueva reserva.");
            Data.reservas.remove(reserva);
        } else {
            System.out.println("Opción no válida.");
        }
    }
}
