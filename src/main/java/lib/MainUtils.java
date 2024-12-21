package lib;

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

  public static void handleExitOption() {
    System.out.println("Saliendo del sistema. ¡Gracias por usar el sistema de reservas!");
  }
}
