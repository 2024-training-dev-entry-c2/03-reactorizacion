package org.bymarium.hotel.services;

import org.bymarium.hotel.models.Accommodation;
import org.bymarium.hotel.services.interfaces.IMenuService;
import org.bymarium.hotel.services.interfaces.IValidatorService;

import java.util.Arrays;
import java.util.List;

public class MenuService implements IMenuService {
  private final IValidatorService validatorService;
  private final AccommodationService accommodationService;

  public MenuService(IValidatorService validatorService, AccommodationService accommodationService) {
    this.validatorService = validatorService;
    this.accommodationService = accommodationService;
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

  @Override
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

  @Override
  public void makeBooking() {
    System.out.println(
      "\n============================================================\n" +
      "                  RESERVA DE ALOJAMIENTO                    \n" +
      "============================================================\n"
    );

    String city = accommodationService.getCity();
    String accommodationType = accommodationService.getAccommodationType();
    Accommodation accommodation = accommodationService.getSelectedAccommodation(city, accommodationType);

    System.out.println(city);
    System.out.println(accommodationType);
    System.out.println(accommodation.printAccommodation());
  }
}
