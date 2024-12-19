package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final AlojamientoView alojamientosView;
    private final ReservaView reservasView;

    public Menu(AlojamientoView alojamientos, ReservaView reservas) {
        this.alojamientosView = alojamientos;
        this.reservasView = reservas;
    }

    public void procesarReserva(Scanner scanner) {
        //paso 1
        String ciudad = seleccionarOpcionDeLista(scanner, "Selecciona una ciudad:", alojamientosView.obtenerCiudades());
        if (ciudad == null) return;
        //paso 2
        String tipo = seleccionarOpcionDeLista(scanner, "Selecciona un tipo de alojamiento:", alojamientosView.obtenerTipos());
        if (tipo == null) return;
        //paso3
        DatosConsulta datosConsulta = obtenerDatosReserva(scanner);
        if (datosConsulta == null) return;
        //paso4
        List<Alojamientos> alojamientosFiltrados = alojamientosView.filtrar(ciudad, tipo);
        Alojamientos alojamientoSeleccionado = seleccionarAlojamiento(scanner, alojamientosFiltrados);
        if (alojamientoSeleccionado == null) return;
        alojamientoSeleccionado.mostrarAlojamiento();
        //paso5
        Habitacion habitacionSeleccionada = seleccionarHabitacion(scanner, alojamientoSeleccionado, datosConsulta);
        if (habitacionSeleccionada == null) return;

        if (!habitacionSeleccionada.maxPersonas(datosConsulta.getCantidadAdultos(), datosConsulta.getCantidadNinos())) {
            System.out.println("No hay espacio, se aplicarán cargos adicionales.");
        }

        //paso6
        Integer opcionAutenticar = MenuHelper.seleccionarOpcionMenu(scanner, "Proceso a seguir:", new String[]{"Hacer Reserva"});
        if (opcionAutenticar == -1) return;

        //paso 7
        confirmarReserva(scanner, alojamientoSeleccionado, habitacionSeleccionada, datosConsulta);

    }

    public void gestionReserva(Scanner scanner) {
        String email = MenuHelper.obtenerEntradaValidaTexto(scanner, "Ingrese su Correo: ");
        LocalDate fechaNacimiento = MenuHelper.obtenerEntradaValidaFecha(scanner, "Fecha de Nacimiento ");
        reservasView.autenticarReserva(scanner, email, fechaNacimiento);
    }

    static public Integer mostrarMenuInicial(Scanner scanner) {
        String[] opciones = {"Consultar y reservar", "Autenticar y Actualizar"};
        Integer seleccion = MenuHelper.seleccionarOpcionMenu(scanner, "___Bienvenido a Booking Hotel___", opciones);
        return (seleccion == 0) ? 1 : (seleccion == 1 ? 2 : 0);
    }

    private String seleccionarOpcionDeLista(Scanner scanner, String mensaje, List<String> opciones) {
        Integer index = MenuHelper.seleccionarOpcion(scanner, mensaje, opciones);
        return (index == -1) ? null : opciones.get(index);
    }

    private DatosConsulta obtenerDatosReserva(Scanner scanner) {
        try {
            LocalDate fechaInicio = MenuHelper.obtenerEntradaValidaFecha(scanner, "Ingrese el día de inicio del hospedaje: ");
            LocalDate fechaFin = MenuHelper.obtenerEntradaValidaFecha(scanner, "Ingrese el día de finalización del hospedaje: ");
            Integer cantidadAdultos = MenuHelper.obtenerEntradaValida(scanner, "Ingrese la cantidad de adultos: ");
            Integer cantidadNinos = MenuHelper.obtenerEntradaValida(scanner, "Ingrese la cantidad de niños: ");
            Integer cantidadHabitaciones = MenuHelper.obtenerEntradaValida(scanner, "Ingrese la cantidad de habitaciones: ");

            return new DatosConsulta(fechaInicio, fechaFin, cantidadAdultos, cantidadNinos, cantidadHabitaciones);
        } catch (Exception e) {
            System.out.println("Error al obtener los datos de la reserva. Inténtelo nuevamente.");
            return null;
        }
    }

    private Alojamientos seleccionarAlojamiento(Scanner scanner, List<Alojamientos> alojamientos) {
        alojamientos.forEach(Alojamientos::mostrarAlojamiento);
        Integer index = MenuHelper.seleccionarOpcion(scanner, "Selecciona un alojamiento:", alojamientos.stream().map(Alojamientos::getNombre).toList());
        return (index == -1) ? null : alojamientos.get(index);
    }

    private Habitacion seleccionarHabitacion(Scanner scanner, Alojamientos alojamiento, DatosConsulta datosConsulta) {
//        alojamiento.mostrarAlojamiento();
        List<Habitacion> habitaciones = alojamiento.getHabitaciones();
        habitaciones.forEach(h -> h.mostrarHabitacion(datosConsulta.getCantidadHabitaciones(),
                datosConsulta.getFechaInicio(), datosConsulta.getFechaFin()));
        Integer index = MenuHelper.seleccionarOpcion(scanner, "Selecciona la habitación a reservar:",
                habitaciones.stream().map(Habitacion::getTipo).toList());
        return (index == -1) ? null : habitaciones.get(index);
    }

    private void confirmarReserva(Scanner scanner, Alojamientos alojamiento, Habitacion habitacion, DatosConsulta datosConsulta) {
        String nombre = "Martin";// obtenerEntradaValidaTexto(scanner, "Escriba su nombre: ");
        String apellido = "Parada";//obtenerEntradaValidaTexto(scanner, "Escriba su apellido: ");
        LocalDate fechaNacimiento = LocalDate.parse("2000-05-23");// obtenerEntradaValidaFecha(scanner, "Escriba su Fecha de Nacimiento dd/MM/yyyy : ");
        String nacionalidad = "COl";//obtenerEntradaValidaTexto(scanner, "Escriba su Nacionalidad: ");
        String email = "m@gmail.com";//obtenerEntradaValidaTexto(scanner, "Escriba su email: ");
        Integer telefono = 123123123; //obtenerEntradaValida(scanner, "Escriba su telefono: ");
        Integer hora = 5;//obtenerEntradaValida(scanner, "Escriba la hora de llegada: ");
        Cliente cliente = new Cliente(nombre, apellido, nacionalidad, telefono, email, fechaNacimiento);
        Boolean reservaExitosa = reservasView.crearReserva(cliente, alojamiento, habitacion, datosConsulta.getFechaInicio(), datosConsulta.getFechaFin(), datosConsulta.getCantidadHabitaciones());
        if (reservaExitosa) {
            System.out.println("¡Felicidades! Reserva realizada exitosamente!!!!" + "\n Alojamiento seleccionado: " + alojamiento.getNombre() + "\n Habitación seleccionada: " + habitacion.getTipo());
        } else {
            System.out.println("Hubo un problema al realizar la reserva. Intente nuevamente.");
        }
    }
}
