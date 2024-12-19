package org.example.models;

import java.util.List;

public class Finca extends Alojamiento {

    private boolean tienePiscina;

    public Finca() {
    }

    public Finca(String nombre, String ubicacion, float calificacion, List<Habitacion> habitaciones, boolean tienePiscina) {
        super(nombre, ubicacion, calificacion, habitaciones);
        this.tienePiscina = tienePiscina;
    }

    public boolean isTienePiscina() {
        return tienePiscina;
    }

    public void setTienePiscina(boolean tienePiscina) {
        this.tienePiscina = tienePiscina;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Finca: " + getNombre() + ", Ubicación: " + getUbicacion() +
                ", Calificación: " + getCalificacion() + " estrellas, Piscina: " + (tienePiscina ? "Sí" : "No"));
    }
}
