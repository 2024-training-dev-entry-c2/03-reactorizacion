package com.example.services;

import com.example.services.interfaces.IInputValidatorService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class InputInputValidatorService implements IInputValidatorService {
    private final Scanner scanner;

    public InputInputValidatorService(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public Integer readInt(String prompt) {
        int input;
        while (true) {
            try {
                System.out.println(prompt);
                input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Entrada inválida. Por favor ingrese un número entero.");
            }
        }
    }

    public LocalDate readLocalDate(String prompt) {
        LocalDate date;
        while (true) {
            try {
                System.out.println(prompt);
                date = LocalDate.parse(scanner.nextLine());
                return date;
            } catch (Exception e) {
                System.err.println("Fecha inválida. El formato debe ser: yyyy-MM-dd");
            }
        }
    }

    public LocalTime readLocalTime(String prompt) {
        LocalTime time;
        while (true) {
            try {
                System.out.println(prompt);
                time = LocalTime.parse(scanner.nextLine());
                return time;
            } catch (Exception e) {
                System.err.println("Hora inválida. El formato debe ser: HH:mm");
            }
        }
    }

    public void clearBuffer() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

}
