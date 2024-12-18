package org.example;

import java.util.List;

public class Apartamento extends Alojamientos{

    public Apartamento(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitacion) {
        super(nombre, ciudad, tipo, calificacion, habitacion);
    }

    public Apartamento() {
    }

    @Override
    public void mostrarAlojamiento() {
        System.out.println(getCiudad() + ":" + getTipo());
        System.out.println("-----------------------------------------------------------");
        System.out.println("Ciudad Seleccionada: " + getCiudad());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Precio: " + getHabitaciones().get(0).getPrecio());
        System.out.println("Calificación: " + getCalificacion() + "⭐");
    }
}
