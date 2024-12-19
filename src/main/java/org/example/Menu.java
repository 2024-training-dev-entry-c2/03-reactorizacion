package org.example;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public class Menu {
    public static void display(){
        String menu = """
                1 - Buscar alojamientos disponibles
                2 - Ver habitaciones disponibles
                3 - Crear una reserva
                4 - Ver registro de reservas
                5 - Actualizar una reserva
                0 - Salir
                """;
        System.out.println("\n---------App Booking Hoteles----------- \n");
        System.out.println(menu);
    }
}
