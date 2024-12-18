package org.example;

import java.util.Scanner;

public class BookingSystem {
    private final AlojamientoVisualizacion alojamientoService;
    private final Menu menuService;
    public BookingSystem() {
        alojamientoService = new AlojamientoVisualizacion();
        menuService = new Menu(alojamientoService);
        alojamientoService.inicializarDatos();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int opcion = menuService.mostrarMenuInicial(scanner);
            if (opcion == 1) {
                menuService.procesarReserva(scanner);
            } else if (opcion == 2) {

            } else {
                System.out.println("¡Gracias por usar el sistema de reservas!");
                break;
            }
        }
    }
}
