package org.example;

import java.util.List;

public class Finca extends Alojamientos{
    public Finca(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitacion) {
        super(nombre, ciudad, tipo, calificacion, habitacion);
    }

    public Finca() {
    }
}
