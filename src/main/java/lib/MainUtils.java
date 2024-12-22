package lib;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainUtils {

  public static void printMenu() {
    System.out.println("----- Sistema de Reservas -----");
    System.out.println("1. Buscar Alojamientos");
    System.out.println("2. Buscar Habitaciones");
    System.out.println("3. Reservar");
    System.out.println("4. Modificar Reserva");
    System.out.println("5. Salir");
    System.out.print("Ingresa una opción: ");
  }

  public static Integer getUserChoice(Scanner scanner) {
    while (true) {
      try {
        return scanner.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Entrada inválida. Por favor, ingresa un número.");
        scanner.nextLine();
      }
    }
  }
}
