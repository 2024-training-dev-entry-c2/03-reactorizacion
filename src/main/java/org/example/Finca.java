package org.example;

import java.util.List;

public class Finca extends Alojamientos{
    public Finca(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitacion) {
        super(nombre, ciudad, tipo, calificacion, habitacion);
    }
    public Finca() {
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
