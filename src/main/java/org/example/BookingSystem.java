package org.example;

import java.util.Scanner;

public class BookingSystem {
    private final AlojamientoVisualizacion alojamientoService;
    private final ReservaVisualizacion reservaService;
    private final Menu menuService;
    public BookingSystem() {
        alojamientoService = new AlojamientoVisualizacion();
        reservaService = new ReservaVisualizacion();
        menuService = new Menu(alojamientoService,reservaService);
        alojamientoService.inicializarDatos();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int opcion = menuService.mostrarMenuInicial(scanner);
            if (opcion == 1) {
                menuService.procesarReserva(scanner);
            } else if (opcion == 2) {
                menuService.gestionReserva(scanner);
            } else {
                System.out.println("¡Gracias por usar el sistema de reservas!"+opcion);
                break;
            }
        }
    }
}
