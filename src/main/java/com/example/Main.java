package com.example;

import com.example.data.DataBase;
import com.example.services.BookingService;
import com.example.services.MenuService;
import com.example.services.InputInputValidatorService;
import com.example.services.interfaces.IMenuService;
import com.example.services.interfaces.IInputValidatorService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = DataBase.getInstance();
        Scanner scanner = new Scanner(System.in);
        IInputValidatorService validatorService = new InputInputValidatorService(scanner);
        IMenuService menuService = new MenuService(validatorService);
        BookingService bookingService = new BookingService(dataBase, menuService, validatorService);

        bookingService.start();
    }
}
