package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
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
        String ciudad = seleccionarOpcionDeLista(scanner, "Selecciona una ciudad:", alojamientos.obtenerCiudades());
        if (ciudad == null) return;
        //paso 2
        String tipo = seleccionarOpcionDeLista(scanner, "Selecciona un tipo de alojamiento:", alojamientos.obtenerTipos());
        if (tipo == null) return;
        //paso3
//        LocalDate fechaInicio = MenuHelper.obtenerEntradaValidaFecha(scanner, "Ingrese el día de inicio del hospedaje: ");
//        LocalDate fechaFin = MenuHelper.obtenerEntradaValidaFecha(scanner, "Ingrese el día de finalización del hospedaje: ");
//        Integer cantidadAdultos = MenuHelper.obtenerEntradaValida(scanner, "Ingrese la cantidad de adultos: ");
//        Integer cantidadNinos = MenuHelper.obtenerEntradaValida(scanner, "Ingrese la cantidad de niños: ");
//        Integer cantidadHabitaciones = MenuHelper.obtenerEntradaValida(scanner, "Ingrese la cantidad de habitaciones: ");
        LocalDate fechaInicio =LocalDate.parse("2024-12-25");// obtenerEntradaValidaFecha(scanner, "Ingrese el día de inicio del hospedaje: ");
        LocalDate fechaFin = LocalDate.parse("2024-12-29");//obtenerEntradaValidaFecha(scanner, "Ingrese el día de finalización del hospedaje: ");
        Integer cantidadAdultos =2;// obtenerEntradaValida(scanner, "Ingrese la cantidad de adultos: ");
        Integer cantidadNinos = 1;//obtenerEntradaValida(scanner, "Ingrese la cantidad de niños: ");
        Integer cantidadHabitaciones =1;// obtenerEntradaValida(scanner, "Ingrese la cantidad de habitaciones: ");

        //paso4

        List<Alojamientos> alojamientosFiltrados = alojamientos.filtrar(ciudad, tipo);
        Alojamientos alojamientoSeleccionado = seleccionarAlojamiento(scanner, alojamientosFiltrados);
        if (alojamientoSeleccionado == null) return;
        alojamientoSeleccionado.mostrarAlojamiento();
        //paso5

        Habitacion habitacionSeleccionada = seleccionarHabitacion(scanner, alojamientoSeleccionado, cantidadHabitaciones, fechaInicio, fechaFin);
        if (habitacionSeleccionada == null) return;
        System.out.println("Habitación seleccionada: " + habitacionSeleccionada.getTipo());

        //paso6
        int opcionAutenticar = MenuHelper.seleccionarOpcionMenu(scanner, "Proceso a seguir:", new String[]{"Hacer Reserva"});
        if (opcionAutenticar == -1) return;

        //paso 7
        confirmarReserva(scanner, alojamientoSeleccionado, habitacionSeleccionada, fechaInicio, fechaFin);

    }

    public void gestionReserva(Scanner scanner) {
        String email = MenuHelper.obtenerEntradaValidaTexto(scanner, "Ingrese su Correo: ");
        LocalDate fechaNacimiento = MenuHelper.obtenerEntradaValidaFecha(scanner, "Fecha de Nacimiento ");
        reservas.autenticarReserva(scanner, email, fechaNacimiento);
    }

    static public int mostrarMenuInicial(Scanner scanner) {
        String[] opciones = {"Consultar y reservar", "Autenticar y Actualizar"};
        int seleccion = MenuHelper.seleccionarOpcionMenu(scanner, "___Bienvenido a Booking Hotel___", opciones);
        return (seleccion == 0) ? 1 : (seleccion == 1 ? 2 : 0);
    }

    private String seleccionarOpcionDeLista(Scanner scanner, String mensaje, List<String> opciones) {
        int index = MenuHelper.seleccionarOpcion(scanner, mensaje, opciones);
        return (index == -1) ? null : opciones.get(index);
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

    private Alojamientos seleccionarAlojamiento(Scanner scanner, List<Alojamientos> alojamientos) {
        alojamientos.forEach(Alojamientos::mostrarAlojamiento);
        int index = MenuHelper.seleccionarOpcion(scanner, "Selecciona un alojamiento:", alojamientos.stream().map(Alojamientos::getNombre).toList());
        return (index == -1) ? null : alojamientos.get(index);
    }

    private Habitacion seleccionarHabitacion(Scanner scanner, Alojamientos alojamiento, int cantidadHabitaciones, LocalDate fechaInicio, LocalDate FechaFin) {
        alojamiento.mostrarAlojamiento();
        List<Habitacion> habitaciones = alojamiento.getHabitaciones();
        habitaciones.forEach(h -> h.mostrarHabitacion(cantidadHabitaciones, fechaInicio, FechaFin));
        int index = MenuHelper.seleccionarOpcion(scanner, "Selecciona la habitación a reservar:", habitaciones.stream().map(Habitacion::getTipo).toList());
        return (index == -1) ? null : habitaciones.get(index);
    }

    private void confirmarReserva(Scanner scanner, Alojamientos alojamiento, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
//        String nombre = MenuHelper.obtenerEntradaValidaTexto(scanner, "Escriba su nombre:");
//        String apellido = MenuHelper.obtenerEntradaValidaTexto(scanner, "Escriba su apellido:");
//        LocalDate fechaNacimiento = MenuHelper.obtenerEntradaValidaFecha(scanner, "Escriba su fecha de nacimiento (yyyy-MM-dd):");
//        String nacionalidad = MenuHelper.obtenerEntradaValidaTexto(scanner, "Escriba su nacionalidad:");
//        String email = MenuHelper.obtenerEntradaValidaTexto(scanner, "Escriba su email:");
//        float telefono = MenuHelper.obtenerEntradaValida(scanner, "Escriba su teléfono:");
        String nombre ="Martin";// obtenerEntradaValidaTexto(scanner, "Escriba su nombre: ");
        String apellido = "Parada";//obtenerEntradaValidaTexto(scanner, "Escriba su apellido: ");
        LocalDate fechaNacimiento = LocalDate.parse("2000-05-23");// obtenerEntradaValidaFecha(scanner, "Escriba su Fecha de Nacimiento dd/MM/yyyy : ");
        String nacionalidad = "COl";//obtenerEntradaValidaTexto(scanner, "Escriba su Nacionalidad: ");
        String email = "m@gmail.com";//obtenerEntradaValidaTexto(scanner, "Escriba su email: ");
        float telefono =123123123; //obtenerEntradaValida(scanner, "Escriba su telefono: ");
        int hora = 5;//obtenerEntradaValida(scanner, "Escriba la hora de llegada: ");
        boolean reservaExitosa = reservas.crearReserva(nombre, apellido, nacionalidad, email, fechaNacimiento, alojamiento, habitacion, telefono, fechaInicio, fechaFin);
        if (reservaExitosa) {
            System.out.println("¡Felicidades! Reserva realizada exitosamente!!!!"+"\n Alojamiento seleccionado: "+alojamiento.getNombre()+"\n Habitación seleccionada: "+habitacion.getTipo());
        } else {
            System.out.println("Hubo un problema al realizar la reserva. Intente nuevamente.");
        }
    }
}
