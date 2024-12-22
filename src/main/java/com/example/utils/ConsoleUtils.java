package com.example.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ConsoleUtils {
  private final Scanner scanner = new Scanner(System.in);

  public String getString(String message) {
    System.out.println(message);
    return scanner.next();
  }

  public Integer getInteger(String message) {
    try {
      System.out.println(message);
      int value = scanner.nextInt();

      if (value < 0) {
        System.out.println("Ingresa un número positivo.");
        return getInteger(message);
      }

      return value;
    } catch (Exception e) {
      System.err.println("Ingresa un número con formato valido.");
      return getInteger(message);
    }
  }

  public LocalDate getLocalDate(String message) {
    try {
      System.out.println(message);
      String input = scanner.nextLine();
      return LocalDate.parse(input);

    } catch (NullPointerException e) {
      System.err.println("Entrada no puede ser null.");
      return getLocalDate(message);

    } catch (Exception e) {
      System.err.println("Ingresa una fecha con formato valido (yyyy-mm-dd).");
      return getLocalDate(message);
    }
  }

  public LocalTime getLocalTime(String message) {
    try {
      System.out.println(message);
      String input = scanner.nextLine();
      LocalTime value = LocalTime.parse(input);
      return value;

    } catch (Exception e) {
      System.err.println("Ingresa una hora con formato valido (HH:mm).");
      return getLocalTime(message);
    }
  }
}