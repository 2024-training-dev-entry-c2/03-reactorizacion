package org.example.models;

public class Habitacion {
    private String tipo;
    private int capacidad;
    private double precioPorNoche;
    private boolean disponible;

    public Habitacion() {
    }

    public Habitacion(String tipo, int capacidad, double precioPorNoche, boolean disponible) {
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.precioPorNoche = precioPorNoche;
        this.disponible = disponible;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return String.format("Tipo: %s, Capacidad: %d personas, Precio por noche: $%.2f, Disponible: %s",
                tipo, capacidad, precioPorNoche, (disponible ? "Sí" : "No"));
    }
}
