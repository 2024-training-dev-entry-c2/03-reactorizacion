package com.bookinghotels.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ConsolaUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static String obtenerEntrada(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine();
    }

    public static int obtenerEntero(String mensaje) {
        while (true) {
            try {
                System.out.println(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
            }
        }
    }

    public static LocalDate parseFecha(String fecha) {
        try {
            return LocalDate.parse(fecha);
        } catch (Exception e) {
            throw new IllegalArgumentException("Fecha inválida. Usa el formato YYYY-MM-dd.");
        }
    }

    public static LocalTime parseHora(String hora) {
        try {
            return LocalTime.parse(hora);
        } catch (Exception e) {
            throw new IllegalArgumentException("Hora inválida. Usa el formato HH:mm.");
        }
    }
}
