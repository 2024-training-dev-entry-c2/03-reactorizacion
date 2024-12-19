package org.bymarium.hotel.services;

import org.bymarium.hotel.services.interfaces.IMenuService;
import org.bymarium.hotel.services.interfaces.IValidatorService;

import java.util.Arrays;
import java.util.List;

public class MenuService implements IMenuService {
  private final IValidatorService validatorService;

  public MenuService(IValidatorService validatorService) {
    this.validatorService = validatorService;
  }

  @Override
  public Integer showMainMenu(){
    Integer option;
    List<Integer> validOptions = Arrays.asList(1, 2, 3, 4);

    do {
      System.out.println(
        "\n============================================================\n" +
        "                BIENVENIDO A LA APLICACIÓN                 \n" +
          "                DE RESERVA DE ALOJAMIENTOS                 \n" +
          "============================================================\n" +
          "                    ¿QUÉ DESEAS HACER?                     \n" +
          "------------------------------------------------------------\n" +
          "                  (1) Reservar un alojamiento                    \n" +
          "                  (2) Ver reservas               \n" +
          "                  (3) Modificar reserva                 \n" +
          "                  (4) Salir del sistema                 \n" +
          "------------------------------------------------------------\n"
      );

      System.out.println("Selecciona una opción (1-4): ");
      option = validatorService.readInt("");

      if (!validOptions.contains(option)) {
        System.out.println("Opción no válida. Inténtalo nuevamente.");
      }
    } while (!validOptions.contains(option));

    return option;
  }

  public Integer showSecondManu() {
    Integer option;
    List<Integer> validOptions = Arrays.asList(1, 2, 3, 4);

    do {
      System.out.println(
          "------------------------------------------------------------\n" +
          "                    ¿QUÉ DESEAS HACER?                     \n" +
          "------------------------------------------------------------\n" +
          "                  (1) Cambiar habitacion(es)                    \n" +
          "                  (2) Cambiar alojamiento                   \n" +
          "                  (3) Volver al menú principal                 \n" +
          "------------------------------------------------------------\n"
      );

      System.out.println("Selecciona una opción (1-3): ");
      option = validatorService.readInt("");

      if (!validOptions.contains(option)) {
        System.out.println("Opción no válida. Inténtalo nuevamente.");
      }
    } while (!validOptions.contains(option));

    return option;
  }
}
