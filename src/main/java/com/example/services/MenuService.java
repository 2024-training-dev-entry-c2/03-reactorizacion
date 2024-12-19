package com.example.services;

import com.example.services.interfaces.IMenuService;
import com.example.services.interfaces.IValidatorService;

import java.util.List;

public class MenuService implements IMenuService {
    private final IValidatorService validatorService;

    public MenuService(IValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    @Override
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

    public void start() {
        System.out.println("Menu Service started");
    }

}
