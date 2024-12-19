package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class MenuHelper {

    public static void mostrarOpcionesMenu(String mensaje, String[] opciones) {
        System.out.println(mensaje);
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
        System.out.println((opciones.length + 1) + ". Volver");
    }

    static int seleccionarOpcion(Scanner scanner, String mensaje, List<String> opciones) {
        System.out.println(mensaje);
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i));
        }
        System.out.println((opciones.size() + 1) + ". Volver");
        return obtenerEntradaValida(scanner, opciones.size());
    }

    public static int seleccionarOpcionMenu(Scanner scanner, String mensaje, String[] opciones) {
        mostrarOpcionesMenu(mensaje, opciones);
        return obtenerEntradaValida(scanner, opciones.length);
    }


    public static int obtenerEntradaValida(Scanner scanner, int maxOption) {
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

    public static String obtenerEntradaValidaTexto(Scanner scanner, String mensaje) {
        String opcion;
        while (true) {
            System.out.print(mensaje);
            try {
                opcion = scanner.nextLine();
                if (!Objects.equals(opcion, "")) {
                    return opcion;
                }
                System.out.println("La entrada no puede estar vacía.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un texto.");
                scanner.next(); // Limpiar el buffer
            }
        }
    }

    // tipo fecha
    public static LocalDate obtenerEntradaValidaFecha(Scanner scanner, String mensaje) {
        LocalDate opcion;
        while (true) {
            System.out.print(mensaje + "yyyy-MM-dd : ");
            try {
                String input = scanner.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    System.out.println("La entrada no puede estar vacía. Intente de nuevo.");
                    continue;
                }
                opcion = LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                return opcion;
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, ingrese una fecha válida.");
            }
        }
    }
}


