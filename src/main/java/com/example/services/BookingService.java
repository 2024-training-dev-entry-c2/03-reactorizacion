package com.example.services;

import com.example.data.DataBase;
import com.example.models.Accommodation;
import com.example.services.interfaces.IBookingService;
import com.example.services.interfaces.IMenuService;
import com.example.services.interfaces.IValidatorService;

import java.util.Scanner;


public class BookingService implements IBookingService {

    private final DataBase dataBase;
    private final IMenuService menuService;

    public BookingService(DataBase dataBase, IMenuService menuService) {
        this.dataBase = dataBase;
        this.menuService = menuService;
    }


    @Override
    public void start() {
        Integer option = menuService.mainMenu();

        do {
            switch (option) {
                case 1 -> {
                    System.out.println("Reservar alojamiento");
                    listCities();
//                    listHotels();
                }
                case 2 -> System.out.println("Ver reservas");
                case 3 -> System.out.println("Modificar reserva");
            }
            option = menuService.mainMenu();
        } while (option != 4);
    }

    @Override
    public void askForDetails() {
    }

    public void listCities() {
        System.out.println("Listado de ciudades");
        for (String city : dataBase.getCities()) {
            System.out.print(city + " | ");
        }
        System.out.println();
    }

    public void listHotels() {
        System.out.println("Listado de hoteles");
        for (Accommodation accommodation : dataBase.getAccommodations()) {
            System.out.println(accommodation.getName());
        }
    }
}
