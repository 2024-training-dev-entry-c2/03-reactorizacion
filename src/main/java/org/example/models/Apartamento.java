package org.example.models;

import java.util.List;

public class Apartamento extends Alojamiento {

    private int piso;
    private boolean tieneAscensor;

    public Apartamento() {
    }

    public Apartamento(String nombre, String ubicacion, float calificacion, List<Habitacion> habitaciones, int piso, boolean tieneAscensor) {
        super(nombre, ubicacion, calificacion, habitaciones);
        this.piso = piso;
        this.tieneAscensor = tieneAscensor;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public boolean isTieneAscensor() {
        return tieneAscensor;
    }

    public void setTieneAscensor(boolean tieneAscensor) {
        this.tieneAscensor = tieneAscensor;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Apartamento: " + getNombre() + ", Ubicación: " + getUbicacion() +
                ", Calificación: " + getCalificacion() + " estrellas, Piso: " + piso +
                ", Ascensor: " + (tieneAscensor ? "Sí" : "No"));
    }
}
