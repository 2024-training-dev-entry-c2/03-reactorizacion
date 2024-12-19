package org.example.models;

import java.util.List;

public class Hotel extends Alojamiento{

    public Hotel() {
    }

    public Hotel(String nombre, String ubicacion, int calificacion, List<Habitacion> habitaciones) {
        super(nombre, ubicacion, calificacion, habitaciones);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Hotel: " + getNombre() + "Ubicación " + getUbicacion() + "Calificación: " +
                getCalificacion() + " estrellas" );
    }
}
