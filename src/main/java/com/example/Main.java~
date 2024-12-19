package com.example;

import com.example.data.DataBase;
import com.example.services.BookingService;
import com.example.services.MenuService;
import com.example.services.ValidatorService;
import com.example.services.interfaces.IMenuService;
import com.example.services.interfaces.IValidatorService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = DataBase.getInstance();
        Scanner scanner = new Scanner(System.in);
        IValidatorService validatorService = new ValidatorService(scanner);
        IMenuService menuService = new MenuService(validatorService);
        BookingService bookingService = new BookingService(dataBase, menuService);

        bookingService.start();
    }
}
