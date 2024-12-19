package org.example.a;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class BookingService {

    public static Scanner Keyboard = new Scanner(System.in);

    public static int ingresarFecha(String mensaje) {
        System.out.println(mensaje);
        return ingresarFecha();
    }

    public static int ingresarNumeroPositivo(String mensaje) {
        while (true) {
            int numero = ingresarNumero(mensaje);
            if (numero > 0) return numero;
            System.out.println("No es un numero válido");
        }
    }

    public static int ingresarFecha() {
        while (true) {
            int dia = ingresarNumero("Ingrese el dia: ");
            if (dia < 1 || dia > 31) {
                limpiarConsola();
                System.out.println("Error ingrese los datos nuevamente");
                continue;
            }
            return dia;
        }
    }

    public static Date ingresarNacimientoFecha() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            String inputFecha = ingresarTexto("Ingresa una fecha (dd/MM/yyyy): ");
            try {
                return formatoFecha.parse(inputFecha);
            } catch (Exception e) {
                System.out.println("Error: la fecha no tiene el formato correcto.");
            }
        }
    }

    public static LocalTime ingresarHoraDeLlegada() {
        while (true) {
            String input = ingresarTexto("Ingrese una hora en formato HH:mm (ejemplo 14:30):");
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                return LocalTime.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Hora inválida. Asegúrese de ingresar el formato correcto.");
            }
        }
    }

    public static String ingresarTexto(String msg) {
        System.out.print(msg);
        return Keyboard.nextLine();
    }

    public static int ingresarNumero(String msg) {
        int numero = 0;
        System.out.print(msg);
        while (true) {
            if (Keyboard.hasNextInt()) {
                numero = Keyboard.nextInt();
                break;
            } else {
                System.out.println("Error: Debe ingresar un número válido. Intente nuevamente.");
                Keyboard.next();
            }
        }
        return numero;
    }

    public static void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

}
