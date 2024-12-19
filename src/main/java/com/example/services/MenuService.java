package com.example.services;

import com.example.models.DayPass;
import com.example.services.interfaces.IMenuService;
import com.example.services.interfaces.IValidatorService;

import java.util.List;

public class MenuService implements IMenuService {
    private final IValidatorService validatorService;

    public MenuService(IValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    public Integer mainMenu() {

        System.out.println(
                "Biernvenido a nuestro sistema de Booking Colombia\n" +
                        "1. Reservar alojamiento\n" +
                        "2. Ver reservas\n" +
                        "3. Modificar reserva\n" +
                        "4. Salir\n"
        );

        Integer option = validatorService.readInt("Seleccione una opción: ");
        List<Integer> validOptions = List.of(1, 2, 3, 4);
        if (!validOptions.contains(option)) {
            System.out.println("Opción inválida. Por favor seleccione una opción válida.");
            return mainMenu();
        }
        return option;
    }

    public Integer accommodationMenu() {
        System.out.println(
                "1. Ver alojamientos\n" +
                        "2. Ver día de sol\n" +
                        "3. Volver\n"
        );

        Integer option = validatorService.readInt("Seleccione una opción: ");
        List<Integer> validOptions = List.of(1, 2, 3);
        if (!validOptions.contains(option)) {
            System.out.println("Opción inválida. Por favor seleccione una opción válida.");
            return accommodationMenu();
        }
        return option;
    }

    public void listDaypassesByCity(String city) {
        System.out.println("Día de sol disponibles en " + city + ":");
        for (DayPass dayPass : dataBase.getDayPasses()) {
            if (dayPass.getCity().equalsIgnoreCase(city)) {
                System.out.println(dayPass.getName() + " - " + dayPass.getPersonPrice() + " USD por persona");
            }
        }
    }

    public Integer passDayMenu() {
        System.out.println(
                "Estos son los alojamientos de día de sol disponibles:\n"
        );

        Integer option = validatorService.readInt("Seleccione una opción: ");
        List<Integer> validOptions = List.of(1, 2);
        if (!validOptions.contains(option)) {
            System.out.println("Opción inválida. Por favor seleccione una opción válida.");
            return passDayMenu();
        }
        return option;
    }


}
