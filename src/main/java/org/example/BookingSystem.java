package org.example;

import java.util.Scanner;

public class BookingSystem {
    private final AlojamientoView alojamientoService;
    private final ReservaView reservaService;
    private final Menu menuService;
    public BookingSystem() {
        alojamientoService = new AlojamientoView();
        reservaService = new ReservaView();
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
