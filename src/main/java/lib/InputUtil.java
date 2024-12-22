package lib;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputUtil {
  public static String getStringInput(Scanner scanner, String prompt) {
    System.out.print(prompt);
    return scanner.nextLine();
  }

  public static Integer getIntInput(Scanner scanner, String prompt) {
    System.out.print(prompt);
    return Integer.parseInt(scanner.nextLine());
  }

  public static LocalDate getDateInput(Scanner scanner, String prompt) {
    System.out.print(prompt);
    return LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_DATE);
  }

  public static LocalTime getTimeInput(Scanner scanner, String prompt) {
    System.out.print(prompt);
    return LocalTime.parse(scanner.nextLine(), DateTimeFormatter.ISO_TIME);
  }
}