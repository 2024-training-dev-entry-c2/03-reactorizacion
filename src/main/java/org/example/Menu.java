package org.example;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final AlojamientoVisualizacion alojamientos;

    public Menu(AlojamientoVisualizacion alojamientos) {
        this.alojamientos = alojamientos;
    }

    public void procesarReserva(Scanner scanner) {
        List<String> ciudades = alojamientos.obtenerCiudades();
        int ciudadIndex = seleccionarOpcion(scanner, "Selecciona una ciudad:", ciudades);
        if (ciudadIndex == -1) return;

        List<String> tipos = alojamientos.obtenerTipos();
        int tipoIndex = seleccionarOpcion(scanner, "Selecciona un tipo de alojamiento:", tipos);
        if (tipoIndex == -1) return;

        String ciudad = ciudades.get(ciudadIndex);
        String tipo = tipos.get(tipoIndex);
        List<Alojamientos> filtrados = alojamientos.filtrar(ciudad, tipo);
        int alojamientoIndex = seleccionarOpcion(scanner, "Selecciona un alojamiento:", filtrados.stream().map(Alojamientos::getNombre).toList());
        if (alojamientoIndex == -1) return;

        // continuar con la reserva :c
    }

    public void gestionReserva(Scanner scanner) {


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
        int seleccion = seleccionarOpcionMenu(scanner, "___Bienvenido a Booking Hotel___", opciones);
        return (seleccion == 0) ? 1 : (seleccion == 1 ? 9 : 0);
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


}
