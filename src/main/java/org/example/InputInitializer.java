package org.example;

import java.util.Scanner;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public class InputInitializer {

    public static final Scanner INSTANCE = new Scanner(System.in);

    private InputInitializer() {
    }

    public static Scanner getInstance() {
        return INSTANCE;
    }
}

