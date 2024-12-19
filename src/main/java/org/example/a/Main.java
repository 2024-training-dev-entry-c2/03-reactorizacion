package org.example.a;


public class Main {

    public static void main(String[] args) {
        AlojamientoService.controladoraApp.cargarDatos();
        BookingService.limpiarConsola();
        System.out.println("-----------------------------");
        System.out.println("BIENVENIDO A Booking Hoteles");
        AlojamientoService.seleccionarAlojamiento();
    }

}



