package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final AlojamientoVisualizacion alojamientos;
    private final ReservaVisualizacion reservas;

    public Menu(AlojamientoVisualizacion alojamientos, ReservaVisualizacion reservas) {
        this.alojamientos = alojamientos;
        this.reservas = reservas;
    }

    public void procesarReserva(Scanner scanner) {
        //paso 1
        List<String> ciudades = alojamientos.obtenerCiudades();
        int ciudadIndex = MenuHelper.seleccionarOpcion(scanner, "Selecciona una ciudad:", ciudades);
        if (ciudadIndex == -1) return;
        //paso 2
        List<String> tipos = alojamientos.obtenerTipos();
        int tipoIndex = MenuHelper.seleccionarOpcion(scanner, "Selecciona un tipo de alojamiento:", tipos);
        if (tipoIndex == -1) return;
        //paso3
        LocalDate fechaInicio = MenuHelper.obtenerEntradaValidaFecha(scanner, "Ingrese el día de inicio del hospedaje: ");
        LocalDate fechaFin = MenuHelper.obtenerEntradaValidaFecha(scanner, "Ingrese el día de finalización del hospedaje: ");
        Integer cantidadAdultos = MenuHelper.obtenerEntradaValida(scanner, "Ingrese la cantidad de adultos: ");
        Integer cantidadNinos = MenuHelper.obtenerEntradaValida(scanner, "Ingrese la cantidad de niños: ");
        Integer cantidadHabitaciones = MenuHelper.obtenerEntradaValida(scanner, "Ingrese la cantidad de habitaciones: ");
        //paso4
        String ciudad = ciudades.get(ciudadIndex);
        String tipo = tipos.get(tipoIndex);
        List<Alojamientos> filtrados = alojamientos.filtrar(ciudad, tipo);
        filtrados.forEach(Alojamientos::mostrarAlojamiento);
        int alojamientoIndex = MenuHelper.seleccionarOpcion(scanner, "Selecciona un alojamiento:", filtrados.stream().map(Alojamientos::getNombre).toList());
        if (alojamientoIndex == -1) return;
        System.out.println("_____________/////_________//////______________");

        //paso5

        Alojamientos alojamientoSeleccionado = filtrados.get(alojamientoIndex);
        alojamientoSeleccionado.mostrarAlojamiento();
        List<Habitacion> habitaciones = alojamientoSeleccionado.getHabitaciones();
        for (Habitacion habitacion : habitaciones) {
            habitacion.mostrarHabitacion(cantidadHabitaciones, fechaInicio, fechaFin);
        }
        int habitacionIndex = MenuHelper.seleccionarOpcion(scanner, "Selecciona la habitación a reservar:",
                habitaciones.stream().map(Habitacion::getTipo).toList());

        alojamientoSeleccionado.mostrarAlojamiento();

        Habitacion habitacionSeleccionada = habitaciones.get(habitacionIndex);
        System.out.println("Habitación seleccionada: " + habitacionSeleccionada.getTipo());

        //paso6
        int opcionAutenticar = MenuHelper.seleccionarOpcionMenu(scanner, "Proceso a seguir:", new String[]{"Hacer Reserva"});
        if (opcionAutenticar == -1) return;


        //paso 7
        String nombre = MenuHelper.obtenerEntradaValidaTexto(scanner, "Escriba su nombre: ");
        String apellido = MenuHelper.obtenerEntradaValidaTexto(scanner, "Escriba su apellido: ");
        LocalDate fechaNacimiento = MenuHelper.obtenerEntradaValidaFecha(scanner, "Escriba su Fecha de Nacimiento dd/MM/yyyy : ");
        String nacionalidad = MenuHelper.obtenerEntradaValidaTexto(scanner, "Escriba su Nacionalidad: ");
        String email = MenuHelper.obtenerEntradaValidaTexto(scanner, "Escriba su email: ");
        float telefono = MenuHelper.obtenerEntradaValida(scanner, "Escriba su telefono: ");
        int hora = MenuHelper.obtenerEntradaValida(scanner, "Escriba la hora de llegada: ");

        //paso 8
        if (reservas.crearReserva(nombre, apellido, nacionalidad, email, fechaNacimiento, alojamientoSeleccionado, habitacionSeleccionada, telefono, fechaInicio, fechaFin)) {

            System.out.println("Felicidades!!!!!!!!!!!!!");
            System.out.println("habitacion seleccionada: " + habitacionSeleccionada.getTipo());
            System.out.println("Alojamiento seleccionado: " + alojamientoSeleccionado.getNombre());

        }


    }

    public void gestionReserva(Scanner scanner) {
        System.out.println("Ingrese su correo :");
        String email = scanner.next();
        System.out.println("Ingrese su fecha de nacimiento (dd/MM/yyyy):");
        LocalDate fechaNacimiento = obtenerEntradaValidaFecha(scanner, "Fecha de Nacimiento: ");
        reservas.autenticarReserva(scanner, email, fechaNacimiento);

    }


    static public int mostrarMenuInicial(Scanner scanner) {
        String[] opciones = {"Consultar y reservar", "Autenticar y Actualizar"};
        int seleccion = MenuHelper.seleccionarOpcionMenu(scanner, "___Bienvenido a Booking Hotel___", opciones);
        return (seleccion == 0) ? 1 : (seleccion == 1 ? 2 : 0);
    }

    public LocalDate obtenerEntradaValidaFecha(Scanner scanner, String mensaje) {
        LocalDate opcion;
        while (true) {
            System.out.print(mensaje + "yyyy-MM-dd");
            try {
                String input = scanner.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    System.out.println("La entrada no puede estar vacía. Intente de nuevo.");
                    continue;
                }
                opcion = LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                if (opcion != null) {
                    return opcion;
                }
                System.out.println("La cantidad no puede ser negativa.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
            }
        }
    }

}
