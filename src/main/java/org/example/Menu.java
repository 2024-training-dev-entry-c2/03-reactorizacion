package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
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
        LocalDate fechaInicio =LocalDate.parse("2024-12-25");// obtenerEntradaValidaFecha(scanner, "Ingrese el día de inicio del hospedaje: ");
        LocalDate fechaFin = LocalDate.parse("2024-12-29");//obtenerEntradaValidaFecha(scanner, "Ingrese el día de finalización del hospedaje: ");
        Integer cantidadAdultos =2;// obtenerEntradaValida(scanner, "Ingrese la cantidad de adultos: ");
        Integer cantidadNinos = 1;//obtenerEntradaValida(scanner, "Ingrese la cantidad de niños: ");
        Integer cantidadHabitaciones =1;// obtenerEntradaValida(scanner, "Ingrese la cantidad de habitaciones: ");
        //paso4
        String ciudad = ciudades.get(ciudadIndex);
        String tipo = tipos.get(tipoIndex);
        List<Alojamientos> filtrados = alojamientos.filtrar(ciudad, tipo);
        filtrados.forEach(Alojamientos::mostrarAlojamiento);
        int alojamientoIndex = seleccionarOpcion(scanner, "Selecciona un alojamiento:", filtrados.stream().map(Alojamientos::getNombre).toList());
        if (alojamientoIndex == -1) return;
        System.out.println("_____________/////_________//////______________");

        //paso5

        Alojamientos alojamientoSeleccionado = filtrados.get(alojamientoIndex);
        alojamientoSeleccionado.mostrarAlojamiento();
        List<Habitacion> habitaciones = alojamientoSeleccionado.getHabitaciones();
        int habitacionIndex = seleccionarOpcion(scanner, "Selecciona la habitación a reservar:",
                habitaciones.stream().map(Habitacion::getTipo).toList());

        alojamientoSeleccionado.mostrarAlojamiento();

        Habitacion habitacionSeleccionada = habitaciones.get(habitacionIndex);
        System.out.println("Habitación seleccionada: " + habitacionSeleccionada.getTipo());

        //paso6
        int opcionAutenticar = seleccionarOpcionMenu(scanner, "Proceso a seguir:", new String[]{"Hacer Reserva"});
        if (opcionAutenticar == -1) return;


        //paso 7
        String nombre ="Martin";// obtenerEntradaValidaTexto(scanner, "Escriba su nombre: ");
        String apellido = "Parada";//obtenerEntradaValidaTexto(scanner, "Escriba su apellido: ");
        LocalDate fechaNacimiento = LocalDate.parse("2000-05-23");// obtenerEntradaValidaFecha(scanner, "Escriba su Fecha de Nacimiento dd/MM/yyyy : ");
        String nacionalidad = "COl";//obtenerEntradaValidaTexto(scanner, "Escriba su Nacionalidad: ");
        String email = "m@gmail.com";//obtenerEntradaValidaTexto(scanner, "Escriba su email: ");
        float telefono =123123123; //obtenerEntradaValida(scanner, "Escriba su telefono: ");
        int hora = 5;//obtenerEntradaValida(scanner, "Escriba la hora de llegada: ");

        //paso 8
        if (reservas.crearReserva(nombre, apellido, nacionalidad, email, fechaNacimiento, alojamientoSeleccionado, habitacionSeleccionada, telefono, fechaInicio, fechaFin)) {

            System.out.println("Felicidades!!!!!!!!!!!!!");

        }System.out.println("mal!!!!!!!!!!!!!");

        //paso 9
        System.out.println("Alojamiento seleccionado: " + habitacionSeleccionada.getTipo());
        System.out.println("Alojamiento seleccionado: " + alojamientoSeleccionado.getNombre());
        System.out.println("tipoindex:" + tipoIndex + "   Ciudad:" + ciudadIndex + "   alojamiento" + alojamientoIndex);


    }

    public void gestionReserva(Scanner scanner) {
        System.out.println("Ingrese su correo :");
        String email = scanner.next();
        System.out.println("Ingrese su fecha de nacimiento (dd/MM/yyyy):");
        LocalDate fechaNacimiento = obtenerEntradaValidaFecha(scanner,"Fecha de Nacimiento: ");
        reservas.autenticarReserva(scanner,email,fechaNacimiento);

    }

    private int seleccionarOpcion(Scanner scanner, String mensaje, List<String> opciones) {
        System.out.println(mensaje);
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i));
        }
        System.out.println((opciones.size() + 1) + ". Volver");
        return obtenerEntradaValida(scanner, opciones.size());
    }

    static public int mostrarMenuInicial(Scanner scanner) {
        String[] opciones = {"Consultar y reservar", "Autenticar y Actualizar"};
        int seleccion = MenuHelper.seleccionarOpcionMenu(scanner, "___Bienvenido a Booking Hotel___", opciones);
        return (seleccion == 0) ? 1 : (seleccion == 1 ? 2 : 0);
    }

    public static int seleccionarOpcionMenu(Scanner scanner, String mensaje, String[] opciones) {
        mostrarOpcionesMenu(mensaje, opciones);
        return obtenerEntradaValida(scanner, opciones.length);
    }

    public static void mostrarOpcionesMenu(String mensaje, String[] opciones) {
        System.out.println(mensaje);
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
        System.out.println((opciones.length + 1) + ". Volver");
    }

    static private int obtenerEntradaValida(Scanner scanner, int maxOption) {
        int opcion;
        while (true) {
            System.out.print("Ingrese un número: ");
            try {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= maxOption) {
                    return opcion - 1;
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

    public int obtenerEntradaValida(Scanner scanner, String mensaje) {
        int opcion;
        while (true) {
            System.out.print(mensaje);
            try {
                opcion = scanner.nextInt();
                if (opcion >= 0) {
                    return opcion;
                }
                System.out.println("La cantidad no puede ser negativa.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
            }
        }
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

    public static String obtenerEntradaValidaTexto(Scanner scanner, String mensaje) {
        String opcion;
        while (true) {
            System.out.print(mensaje);
            try {
                opcion = scanner.nextLine();
                if (!Objects.equals(opcion, "")) {
                    return opcion;  // Aceptamos solo valores no negativos
                }
                System.out.println(opcion);
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un texto.");
                scanner.next(); // Limpiar el buffer
            }
        }
    }

}
